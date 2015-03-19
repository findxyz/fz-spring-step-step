package com.winter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015-3-18.
 */
@Component
public class Apple {

    @Value("${apple.color}")
    private String color;

    @Value("${apple.shape}")
    private String shape;

    @Value("${apple.taste}")
    private String taste;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
