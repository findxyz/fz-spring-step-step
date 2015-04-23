package com.aop;

/**
 * Created by Administrator on 2015-4-23.
 */
public class Chinese implements Human {

    @Override
    public String getLanguage() {
        System.out.println("My language is chinese.");
        return "Chinese";
    }
}
