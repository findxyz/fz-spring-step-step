package com.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015-4-22.
 */
@Aspect
@Component
@Order(1)
public class MyAspect2 {

    private static final Logger logger = Logger.getLogger(MyAspect2.class);

    @Before("execution(* com.aop.*.*Service(..))")
    public void doBefore(){
        logger.info("My Aspect2 doBefore ...");
    }
}
