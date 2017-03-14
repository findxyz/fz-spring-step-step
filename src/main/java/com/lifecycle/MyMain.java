package com.lifecycle;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MyMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycle/lifecycle.xml");

    }
}
