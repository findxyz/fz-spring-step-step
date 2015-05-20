package com.springmvc.model;

/**
 * Created by Administrator on 2015-5-19.
 */
public class Post {
    public Post(){}

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Post(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    private int id;

    private String title;

    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
