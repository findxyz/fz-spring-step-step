package com.foo;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2015-3-11.
 */
public class ExampleInitBean {
    static Logger logger = Logger.getLogger(ExampleInitBean.class);

    public void init(){
        logger.info("invoke init method");
    }

    public void cleanup(){
        logger.info("invoke cleanup method");
    }
}
