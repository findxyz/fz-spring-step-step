package com.hibernate.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2015-5-12.
 */
@Entity
@Table(name = "t_posts")
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

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
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
