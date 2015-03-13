package com.foo;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Administrator on 2015-3-13.
 */
public class MyBeanPostProcessor implements BeanPostProcessor{

    private static Logger logger = Logger.getLogger(MyBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("################bean name: "+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("$$$$$$$$$$$$$$$$bean name: "+beanName);
        return bean;
    }
}
