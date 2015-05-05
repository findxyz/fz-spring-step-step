package com.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015-4-29.
 */
@Repository
public class PostDao{

    /*
    *  extends JdbcDaoSupport
    *  Exception: required 'dataSource' and 'jdbcTemplate'
    *  虽然JdbcDaoSupport提供了这两个属性的set方法
    *  但是在代码中并没有地方给其Autowired
    *  而且xml中也没有进行配置
    *  所以才会出现上面的异常
    *  可以不用Support类，直接使用jdbcTemplate
    *  或者在xml中注入需要的属性
    * */

    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    private SimpleJdbcCall simpleJdbcCall;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("t_posts");
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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
    // simpleJdbcCall 调用存储过程
    public Post queryPostByProcedure(int id){
        Post post = new Post();
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String, Object> out = this.simpleJdbcCall.withProcedureName("p_getPostById").execute(in);
        post.setTitle(out.get("out_title").toString());
        post.setContent(out.get("out_content").toString());
        return post;
    }

    public List<Post> queryAllPosts(){
        return this.jdbcTemplate.query("select id, title, content from t_posts", new PostMapper());
    }

    private static final class PostMapper implements RowMapper<Post>{

        @Override
        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setId(Integer.parseInt(rs.getString("id")));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            return post;
        }
    }

    public int queryTitleLikeCount(String titleLike){

        String sql = "select count(0) from t_posts where title like concat('%', :titleLike, '%')";
        // MapSqlParameterSource or Map
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource().addValue("titleLike", titleLike);
        Map<String, String> map = new HashMap<String, String>();
        map.put("titleLike", titleLike);
        return this.namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
    }

    public int queryCountByBeanParameter(Post post){
        String sql = "select count(0) from t_posts where title like concat('%', :title, '%') and content like concat('%', :content, '%')";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(post);
        return this.namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
    }

    public int[] batchUpdate(final List<Post> posts){
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(posts.toArray());
        String sql = "update t_posts set title = :title, content = :content where id = :id";
        int[] updateCounts = this.namedParameterJdbcTemplate.batchUpdate(sql, batch);
        return updateCounts;
    }

    public static void main(String[] args){
        int arr[][] = {{1,2}, {2,3,4}};
        System.out.println(arr.length);
        System.out.println(arr[1].length);
    }
}
