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
        map.put("TITLE", "mybatis title");
        map.put("CONTENT", "mybatis content");
        postService.savePost(map);
        logger.info(map.get("id"));

        Map map3 = new HashMap();
        map3.put("ID", 163);
        Post post2 = postService.queryPost(map3);
        logger.info(post2.getId() + "," + post2.getTitle() + "," + post2.getContent());

        map3.put("TITLE", "new mybatis title");
        map3.put("CONTENT", post2.getContent());
        postService.updatePost(map3);

        logger.info("========================");

        Map map5 = new HashMap();
        map5.put("ID", 164);
        logger.info(postService.deletePost(map5));

        Map map2 = new HashMap();
        map2.put("TITLE", "mybatis");
        map2.put("CONTENT", "content");
        List<Post> list = postService.queryPosts(map2);
        if(list != null && list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Post post = list.get(i);
                logger.info(i+","+post.getId()+","+post.getTitle()+","+post.getContent());
            }
        }

    }
}
