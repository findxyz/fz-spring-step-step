package com.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015-4-22.
 */
@Aspect
@Component
@Order(2)
public class MyAspect {

    private static final Logger logger = Logger.getLogger(MyAspect.class);

    @Before("execution(* com.aop.*Service.*(..))")
    public void doBefore2(){
        logger.info("My Aspect doBefore2 ...");
    }

    @Before("execution(* com.aop.*Service.*(..))")
    public void doBefore(){
        logger.info("My Aspect doBefore ...");
    }

    @Before("execution(* com.aop.*Service.*(..))")
    public void doBefore3(){
        logger.info("My Aspect doBefore3 ...");
    }

    @After("execution(* com.aop.*Service.*(..))")
    public void doAfter(){
        logger.info("My Aspect doAfter ...");
    }


    @Around("execution(* com.aop.*Service.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("My Aspect doAround ...");
        logger.info(pjp.getSignature().getName());
        logger.info(pjp.getArgs().length > 0 ? pjp.getArgs()[0] : "");
        return pjp.proceed();
    }

    @AfterReturning(
            pointcut="execution(* com.aop.*Service.*(..))",
            returning="retVal")
    public void doAfterReturning(Object retVal){
        logger.info("My Aspect doAfterReturning ...");
        logger.info(retVal);
    }
}
