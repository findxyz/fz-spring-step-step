package com.hibernate.service;

import com.hibernate.dao.PostDao;
import com.hibernate.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015-5-12.
 */
@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public List queryPosts(){
        return postDao.queryPosts();
    }

    public List queryPostsByPage(Post post){
        return postDao.queryPostsByPage(post);
    }

    @Transactional
    public void saveOrUpdatePost(Post post) {
        postDao.saveOrUpdatePost(post);
        // throw new RuntimeException("a");
    }

    @Transactional
    public void deletePost(Post post){
        postDao.deletePost(post);
    }
}
