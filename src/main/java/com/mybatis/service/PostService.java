package com.mybatis.service;

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

    public List<Post> queryPosts(Map params){
        return postMapper.queryPosts(params);
    }

    public Post queryPost(Map params){
        return postMapper.queryPost(params);
    }

    @Transactional
    public Long savePost(Map params){
        return postMapper.savePost(params);
    }

    @Transactional
    public Long updatePost(Map params){
        return postMapper.updatePost(params);
    }

    @Transactional
    public Long deletePost(Map params){
        return postMapper.deletePost(params);
    }
}
