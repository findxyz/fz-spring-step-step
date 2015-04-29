package com.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2015-4-29.
 */
@Service
@Transactional
public class PostService {

    @Autowired
    private PostDao postDao;

    public void save(Post post){
        postDao.save(post);
    }
}
