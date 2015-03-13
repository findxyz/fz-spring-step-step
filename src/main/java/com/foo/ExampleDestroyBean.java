package com.foo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Administrator on 2015-3-11.
 */
@Component
public class ExampleDestroyBean {

    static Logger logger = Logger.getLogger(ExampleDestroyBean.class);

    @PostConstruct
    public void init(){
        logger.info("invoke init method");
    }

    @PreDestroy
    public void cleanup(){
        logger.info("invoke cleanup method");
    }
}
