package com.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015-4-29.
 */
public class ATransactionMain {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"transaction/transactionContext.xml"});
        PostService postService = context.getBean("postService", PostService.class);
        Post post = new Post("hello title2", "world content2");
        postService.save(post);
    }
}
