package com.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public void saveBySimple(Post post){
        postDao.saveBySimple(post);
    }

    public Post queryPostByProcedure(int id){
        return postDao.queryPostByProcedure(id);
    }

    public List<Post> queryAllPosts(){
        return postDao.queryAllPosts();
    }

    public int queryTitleLikeCount(String titleLike){
        return postDao.queryTitleLikeCount(titleLike);
    }

    public int queryCountByBeanParameter(Post post){
        return postDao.queryCountByBeanParameter(post);
    }

    public int[] batchUpdate(final List<Post> posts){
        return postDao.batchUpdate(posts);
    }
}
