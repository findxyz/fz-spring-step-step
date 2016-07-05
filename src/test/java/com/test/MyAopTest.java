package com.test;

import com.aop.MyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ContextConfiguration default loads the same package's same Class name with '-context.xml'
 * In this Class will load com.test.MyAopTest-context.xml
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MyAopTest {

    @Autowired
    MyService myService;

    @Test
    public void doTest(){
        myService.doService();
        String s = myService.doService("HelloWorld");
        Assert.assertEquals("HelloWorld", s);
    }
}
