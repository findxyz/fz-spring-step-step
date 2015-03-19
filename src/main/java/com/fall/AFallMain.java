package com.fall;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015-3-17.
 */
public class AFallMain {
    private static Logger logger = Logger.getLogger(AFallMain.class);

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        Rice myRice = context.getBean("createRice", Rice.class);
        logger.info(myRice.getType());

        RiceFactory riceFactory = context.getBean("riceFactory", RiceFactory.class);
        riceFactory.doWork();
    }
}
