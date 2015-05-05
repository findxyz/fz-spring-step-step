package com.transaction;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-4-29.
 */
public class ATransactionMain {

    private static final Logger logger = Logger.getLogger(ATransactionMain.class);

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"transaction/transactionContext.xml"});
        PostService postService = context.getBean("postService", PostService.class);
//        Post post = new Post("hello title2", "world content2");
//        postService.save(post);
//
//        Post post2 = new Post("Simple insert", "abc");
//        postService.saveBySimple(post2);

        List<Post> posts = new ArrayList<Post>();
        posts.add(new Post(1, "i'm first title 1111111", "i'm first content"));
        posts.add(new Post(2, "i'm second title 2222222", "i'm second content"));
        int[] updateCounts = postService.batchUpdate(posts);
        for(int i=0; i<updateCounts.length; i++){
            logger.info(updateCounts[i]);
        }

        Post retPost = postService.queryPostByProcedure(1);
        logger.info(retPost.getTitle() + "," + retPost.getContent());

        List<Post> list = postService.queryAllPosts();
        for(Post p : list){
            logger.info(p.getId()+","+p.getTitle()+","+p.getContent());
        }

        int titleLikeCount = postService.queryTitleLikeCount("title");
        logger.info(titleLikeCount);

        Post paramPost = new Post("title2", "content2");
        int count = postService.queryCountByBeanParameter(paramPost);
        logger.info(count);

    }
}
