package com.convert;

import org.joda.time.DateTime;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Date;

/**
 * Created by Administrator on 2015-4-9.
 */
public class AConvertMain {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"convertContext.xml"});
        MyService myService = context.getBean("myService", MyService.class);
        Number a = new Integer(1);
        Object o = myService.doIt(a, TypeDescriptor.forObject(a), TypeDescriptor.valueOf(String.class));
        System.out.println(o.getClass());

        FactoryBean<ConversionService> b = new ConversionServiceFactoryBean();
        ConcurrentMapCacheFactoryBean c = new ConcurrentMapCacheFactoryBean();
        System.out.println(b);
        System.out.println(c);

    }
}
