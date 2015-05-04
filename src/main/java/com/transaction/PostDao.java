package com.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015-4-29.
 */
@Repository
public class PostDao{

    /*
    *  extends JdbcDaoSupport
    *  Exception: required 'dataSource' and 'jdbcTemplate'
    *  ��ȻJdbcDaoSupport�ṩ�����������Ե�set����
    *  �����ڴ����в�û�еط�����Autowired
    *  ����xml��Ҳû�н�������
    *  ���ԲŻ����������쳣
    *  ���Բ���Support�ֱ࣬��ʹ��jdbcTemplate
    *  ������xml��ע����Ҫ������
    * */

    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("t_posts");
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    public void save(Post post){
        String sql = "insert into t_posts(title, content) values(?, ?)";
        this.jdbcTemplate.update(sql, new Object[]{post.getTitle(), post.getContent()});
    }

    public void saveBySimple(Post post){
        Map<String, String> map = new HashMap<String, String>(2);
        map.put("title", post.getTitle());
        map.put("content", post.getContent());
        this.simpleJdbcInsert.execute(map);
    }

    /*
    CREATE DEFINER=`root`@`localhost` PROCEDURE `p_getPostById`(IN `in_id` integer,OUT `out_title` varchar(100),OUT `out_content` varchar(100))
    BEGIN
        select title, content into out_title, out_content from t_posts where id = in_id;
    END
    */
    // simpleJdbcCall ���ô洢����
    public Post queryPostByProcedure(int id){
        Post post = new Post();
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String, Object> out = this.simpleJdbcCall.withProcedureName("p_getPostById").execute(in);
        post.setTitle(out.get("out_title").toString());
        post.setContent(out.get("out_content").toString());
        return post;
    }
}
