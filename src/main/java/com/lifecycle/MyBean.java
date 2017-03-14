package com.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MyBean implements InitializingBean {

    private MyInjectBean myInjectBean;

    public void setMyInjectBean(MyInjectBean myInjectBean) {
        this.myInjectBean = myInjectBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(myInjectBean);
    }
}
