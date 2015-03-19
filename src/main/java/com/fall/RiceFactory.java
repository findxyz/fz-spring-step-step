package com.fall;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015-3-17.
 */
@Component
public class RiceFactory {

    private static Logger logger = Logger.getLogger(RiceFactory.class);

    @Bean
    @Qualifier("myRice")
    public Rice createRice(){
        return new Rice("MyRice");
    }

    public void doWork(){
        logger.info("RiceFactory is creating rice...");
    }

}
