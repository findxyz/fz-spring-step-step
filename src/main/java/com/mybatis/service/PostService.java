package com.mybatis.service;

import com.mybatis.dao.PostDao;
import com.mybatis.mapper.PostMapper;
import com.mybatis.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015-5-13.
 */
@Service
public class PostService {

    @Autowired
    private PostMapper<Post, Map> postMapper;

    @Autowired
    private PostDao postDao;

    public List<Post> queryPostsByMapper(Map params){
        return postMapper.queryPosts(params);
    }

    public Post queryPostByMapper(Map params){
        return postMapper.queryPost(params);
    }

    @Transactional
    public Long savePostByMapper(Map params){
        return postMapper.savePost(params);
    }

    @Transactional
    public Long updatePostByMapper(Map params){
        return postMapper.updatePost(params);
    }

    @Transactional
    public Long deletePostByMapper(Map params){
        return postMapper.deletePost(params);
    }

    public List<Post> queryPostsByDao(Map params){
        return postDao.queryPosts(params);
    }

    public Post queryPostByDao(Map params){
        return postDao.queryPost(params);
    }

    @Transactional
    public int savePostByDao(Map params){
        return postDao.savePost(params);
    }

    @Transactional
    public int updatePostByDao(Map params){
        return postDao.updatePost(params);
    }

    @Transactional
    public int deletePostByDao(Map params){
        return postDao.deletePost(params);
    }
}
