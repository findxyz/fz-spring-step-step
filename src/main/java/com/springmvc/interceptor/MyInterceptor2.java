package com.springmvc.interceptor;

import org.joda.time.DateTime;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fz on 2015/6/8.
 */
public class MyInterceptor2 extends HandlerInterceptorAdapter {

    private int openingTime;
    private int closingTime;

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DateTime dt = new DateTime();
        int hours = dt.getHourOfDay();
        if(hours >= openingTime && hours <= closingTime){
            return true;
        }
        System.out.println("not working time");
        response.sendRedirect("http://localhost:8090");
        return false;
    }
}
