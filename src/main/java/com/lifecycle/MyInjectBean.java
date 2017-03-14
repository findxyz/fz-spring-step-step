package com.lifecycle;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/6.
 */
@Component
public class MyInjectBean {

    @Override
    public String toString() {
        return "I'am MyInjectBean";
    }
}
