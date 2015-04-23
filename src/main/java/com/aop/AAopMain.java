package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015-4-22.
 */
public class AAopMain {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"aop/aopContext.xml"});
        MyService myService = context.getBean("myService", MyService.class);
        myService.doService();
        System.out.println("#################");
        myService.doService("abc");

        System.out.println("################# MyAopObjectProxy");
        MyAopObject myAopObject = context.getBean("myAopObjectProxy", MyAopObject.class);
        myAopObject.doIt();

        System.out.println("################# Human");
        Human chinese = context.getBean("chinese", Human.class);
        chinese.getLanguage();

        System.out.println("################# HumanProxy");
        Human chineseProxy = context.getBean("chineseProxy", Human.class);
        chineseProxy.getLanguage();

    }
}
