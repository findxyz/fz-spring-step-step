package com.springmvc.service.impl;

import com.springmvc.service.FooService;
import org.springframework.stereotype.Service;

/**
 * Created by fz on 2015/11/20.
 */
@Service
public class FooServiceImpl implements FooService{

    @Override
    public void sayHello() {
        System.out.println(FooServiceImpl.class + "says hello...");
    }
}
