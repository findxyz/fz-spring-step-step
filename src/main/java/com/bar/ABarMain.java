package com.bar;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015-3-13.
 */
public class ABarMain {

    private static Logger logger = Logger.getLogger(ABarMain.class);

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        Apple apple = context.getBean("apple", Apple.class);
        logger.info(apple.getSize()+","+apple.getWeight()+","+apple.getShape().getName());

        Orange orange = context.getBean("orange", Orange.class);
        logger.info(orange.getSize()+","+orange.getWeight()+","+orange.getShape().getName()+","+orange.getColor());
    }
}
