package com.hibernate;

import com.hibernate.entity.Post;
import com.hibernate.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2015-5-12.
 */
public class AHibernateMain {

    private static final Logger logger = Logger.getLogger(AHibernateMain.class);
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"hibernate/hibernateContext.xml"});
        PostService postService = context.getBean("postService", PostService.class);
//        Post post = new Post("hibernate title exception", "hibernate content");
//        postService.saveOrUpdatePost(post);
//
//        Post post2 = new Post(157, "", "");
//        postService.deletePost(post2);
//
//        Post post3 = new Post(153, "aaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbb");
//        postService.saveOrUpdatePost(post3);

        List list = postService.queryPosts();
        if(list != null && list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Post t = (Post)list.get(i);
                logger.info(t.getId()+","+t.getTitle()+","+t.getContent());
            }
        }

        logger.info("====================================================");

        List list2 = postService.queryPostsByPage(new Post());
        if(list2 != null && list2.size() > 0){
            for(int i=0; i<list2.size(); i++){
                Post t = (Post)list2.get(i);
                logger.info(i+":"+t.getId()+","+t.getTitle()+","+t.getContent());
            }
        }
    }
}
