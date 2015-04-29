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
    *  虽然JdbcDaoSupport提供了这两个属性的set方法
    *  但是在代码中并没有地方给其Autowired
    *  而且xml中也没有进行配置
    *  所以才会出现上面的异常
    *  可以不用Support类，直接使用jdbcTemplate
    *  或者在xml中注入需要的属性
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
