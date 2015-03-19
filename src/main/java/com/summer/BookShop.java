package com.summer;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2015-3-16.
 */
@Component
public class BookShop extends Shop {

    @PostConstruct
    public void init(){
        this.setName("book-shop");
        this.setAddress("star's road");
        this.setContact("132544898989");
    }
}
