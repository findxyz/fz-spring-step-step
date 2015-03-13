package com.foo;

/**
 * Created by Administrator on 2015-3-10.
 */
public class People {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private People spouse;

    public People getSpouse() {
        return spouse;
    }

    public void setSpouse(People spouse) {
        this.spouse = spouse;
    }
}
