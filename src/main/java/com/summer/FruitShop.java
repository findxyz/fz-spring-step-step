package com.summer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015-3-16.
 */
@Component
public class FruitShop extends Shop {

    @Value("${fruitShop.todaySp}")
    private String todaySp;

    public String getTodaySp() {
        return todaySp;
    }

    public void setTodaySp(String todaySp) {
        this.todaySp = todaySp;
    }
}
