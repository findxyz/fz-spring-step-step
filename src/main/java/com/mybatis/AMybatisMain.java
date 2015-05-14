package com.mybatis;

import com.mybatis.model.Post;
import com.mybatis.service.PostService;
import javafx.geometry.Pos;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015-5-13.
 */
public class AMybatisMain {

    private static final Logger logger = Logger.getLogger(AMybatisMain.class);

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"mybatis/mybatisContext.xml"});
        PostService postService = context.getBean("postService", PostService.class);

        Map map = new HashMap();
        map.put("TITLE", "mybatis by mapper title");
        map.put("CONTENT", "mybatis content");
        logger.info("mapper insert: " + postService.savePostByMapper(map));
        logger.info("mapper insert id: " + map.get("id"));

        Map map3 = new HashMap();
        map3.put("ID", 163);
        Post post2 = postService.queryPostByMapper(map3);
        logger.info(post2.getId() + "," + post2.getTitle() + "," + post2.getContent());

        map3.put("TITLE", "new mybatis title");
        map3.put("CONTENT", post2.getContent());
        logger.info("mapper update: " + postService.updatePostByMapper(map3));

        Map map5 = new HashMap();
        map5.put("ID", 164);
        logger.info("mapper delete: " + postService.deletePostByMapper(map5));

        Map map2 = new HashMap();
        map2.put("TITLE", "mybatis by mapper");
        map2.put("CONTENT", "content");
        List<Post> list = postService.queryPostsByMapper(map2);
        if(list != null && list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Post post = list.get(i);
                logger.info(i+","+post.getId()+","+post.getTitle()+","+post.getContent());
            }
        }

        logger.info("========================");

        Map map8 = new HashMap();
        map8.put("TITLE", "mybatis by dao title");
        map8.put("CONTENT", "something");
        logger.info("dao insert: " + postService.savePostByDao(map8));
        logger.info("dao insert id: " + map8.get("id"));

        Map map6 = new HashMap();
        map6.put("ID", 168);
        Post post3 = postService.queryPostByDao(map6);
        logger.info(post3.getId() + "," + post3.getTitle() + "," + post3.getContent());

        map6.put("TITLE", "new mybatis by dao title");
        map6.put("CONTENT", post3.getContent());
        logger.info("dao update: " + postService.updatePostByDao(map6));

        Map map9 = new HashMap();
        map9.put("ID", 167);
        logger.info("dao delete: " + postService.deletePostByDao(map9));

        Map map7 = new HashMap();
        map7.put("TITLE", "mybatis by dao");
        List<Post> list2 = postService.queryPostsByMapper(map7);
        if(list2 != null && list2.size() > 0){
            for(int i=0; i<list2.size(); i++){
                Post post = list2.get(i);
                logger.info(i+","+post.getId()+","+post.getTitle()+","+post.getContent());
            }
        }

    }
}
