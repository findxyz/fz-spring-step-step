package com.transaction;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-4-29.
 */
public class ATransactionMain {

    private static final Logger logger = Logger.getLogger(ATransactionMain.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"transaction/transactionContext.xml"});
        PostService postService = context.getBean("postService", PostService.class);

        Post post = new Post("hello title2", "world content2");
        postService.save(post);

        Post post2 = new Post("Simple insert", "ab\u4E2D\u6587cÖÐÎÄ");
        postService.saveBySimple(post2);

        List<Post> posts = new ArrayList<Post>();
        posts.add(new Post(1, "i'm first title 1111111", "i'm first content"));
        posts.add(new Post(2, "i'm second title 2222222", "i'm second content"));
        int[] updateCounts = postService.batchUpdate(posts);
        for(int i=0; i<updateCounts.length; i++){
            logger.info(updateCounts[i]);
        }

        List<Post> posts2 = new ArrayList<Post>();
        posts2.add(new Post(34, "i'm batch size title", "hello 00000000"));
        posts2.add(new Post(35, "i'm batch size title dd", "hello 12"));
        posts2.add(new Post(36, "i'm batch size title 44$", "hello %%^"));
        int[][] updateCounts2 = postService.batchUpdateBySize(posts2);
        for(int i=0; i<updateCounts2.length; i++){
            for(int j=0; j<updateCounts2[i].length; j++){
                logger.info("int["+i+"]["+j+"]"+updateCounts2[i][j]);
            }
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

        logger.info("\u4E2D");

    }
}
