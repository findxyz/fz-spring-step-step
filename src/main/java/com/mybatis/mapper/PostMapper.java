package com.mybatis.mapper;

import com.mybatis.annotations.RepoMapper;
import com.mybatis.model.Post;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015-5-13.
 */
@RepoMapper
public interface PostMapper<R, P> {

    public List<R> queryPosts(P params);

    public R queryPost(P params);

    public Long savePost(P params);

    public Long updatePost(P params);

    public Long deletePost(P params);
}
