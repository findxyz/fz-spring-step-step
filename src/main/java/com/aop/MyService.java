package com.aop;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015-4-22.
 */
@Component
public class MyService {

    public String doService(){
        return "doing service";
    }

    public String doService(String s){
        return s;
    }
}
