package com.transaction;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015-4-29.
 */
public class ATransactionMain {

    private static final Logger logger = Logger.getLogger(ATransactionMain.class);

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"transaction/transactionContext.xml"});
        PostService postService = context.getBean("postService", PostService.class);
        Post post = new Post("hello title2", "world content2");
        postService.save(post);

        Post post2 = new Post("Simple insert", "abc");
        postService.saveBySimple(post2);

        Post retPost = postService.queryPostByProcedure(1);
        logger.info(retPost.getTitle() + "," + retPost.getContent());
    }
}
