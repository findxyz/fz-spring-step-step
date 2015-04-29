package com.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void save(Post post){
        String sql = "insert into t_posts(title, content) values(?, ?)";
        this.getJdbcTemplate().update(sql, new Object[]{post.getTitle(), post.getContent()});
    }
}
