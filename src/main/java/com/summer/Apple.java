package com.summer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2015-3-16.
 */
@Component("summerApple")
public class Apple {

    @Value("${apple.color}")
    private String color;

    @Autowired
    private Shape shape;

    @Autowired
    private Taste taste;

    @Autowired
    public void init(@Value("${apple.shape}") String shape, @Value("${apple.taste}") String taste){
        this.shape.value = shape;
        this.taste.value = taste;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }
}
