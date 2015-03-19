package com.summer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015-3-16.
 */
@Component
public class MyShops {

    @Autowired
    private Shop fruitShop;

    @Autowired
    private Shop bookShop;

    public Shop getBookShop() {
        return bookShop;
    }

    public void setBookShop(Shop bookShop) {
        this.bookShop = bookShop;
    }

    public Shop getFruitShop() {
        return fruitShop;
    }

    public void setFruitShop(Shop fruitShop) {
        this.fruitShop = fruitShop;
    }
}
