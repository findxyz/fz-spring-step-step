package com.friday;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015-3-20.
 */
public class AFridayMain {
    private static Logger logger = Logger.getLogger(AFridayMain.class);

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"fridayContext.xml"});
        String message = context.getMessage("message", null, "Default", null);
        logger.info(message);

        String warning = context.getMessage("arguments.require", new String[]{"type"}, "some argument require", null);
        logger.info(warning);

        Example e = context.getBean("example", Example.class);
        e.execute();
    }
}
