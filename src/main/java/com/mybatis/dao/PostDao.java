package com.mybatis.dao;

import com.mybatis.model.Post;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015-5-14.
 */
@Repository
public class PostDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Post queryPost(Map params){
        return this.sqlSessionTemplate.<Post>selectOne("com.mybatis.mapper.PostMapper.queryPost", params);
    }

    public List<Post> queryPosts(Map params){
        return this.sqlSessionTemplate.<Post>selectList("com.mybatis.mapper.PostMapper.queryPosts", params);
    }

    public int savePost(Map params){
        return this.sqlSessionTemplate.insert("com.mybatis.mapper.PostMapper.savePost", params);
    }

    public int updatePost(Map params){
        return this.sqlSessionTemplate.update("com.mybatis.mapper.PostMapper.updatePost", params);
    }

    public int deletePost(Map params){
        return this.sqlSessionTemplate.delete("com.mybatis.mapper.PostMapper.deletePost", params);
    }
}
