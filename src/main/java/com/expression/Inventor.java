package com.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-4-10.
 */
public class Inventor {

    private String name;
    private String birthday;
    private String nationality;
    public List<Boolean> myBooleans = new ArrayList<Boolean>();
    public List<String> list;

    public Inventor(String name, String birthday, String nationality){
        this.name = name;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
