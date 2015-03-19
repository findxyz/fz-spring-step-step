package com.winter;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2015-3-18.
 */
public class AWinterMain {

    private static Logger logger = Logger.getLogger(AWinterMain.class);

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("/spring.properties"));
        context.addBeanFactoryPostProcessor(propertySourcesPlaceholderConfigurer);
        context.scan("com");
        context.refresh();

        Apple apple = context.getBean("apple", Apple.class);
        logger.info(apple.getColor()+","+apple.getTaste()+","+apple.getShape());
    }
}
