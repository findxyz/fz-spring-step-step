package com.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/3/6.
 */
@Configuration
public class MyConfiguration {

    @Bean
    MyBean myBean() {
        return new MyBean();
    }
}
