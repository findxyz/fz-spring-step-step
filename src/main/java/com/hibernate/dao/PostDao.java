package com.hibernate.dao;

import com.hibernate.entity.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015-5-12.
 */
@Repository
public class PostDao extends HibernateDaoSupport {

    @Autowired
    public void init(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public List queryPosts(){
        String hql = "from Post";
        return this.getHibernateTemplate().find(hql);
    }

    public List queryPostsByPage(Post post){
        return this.getHibernateTemplate().findByExample(post, 10, 20);
    }

    public void saveOrUpdatePost(Post post) {
        this.getHibernateTemplate().saveOrUpdate(post);
    }

    public void deletePost(Post post){
        this.getHibernateTemplate().delete(post);
    }
}
