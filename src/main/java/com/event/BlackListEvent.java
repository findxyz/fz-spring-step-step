package com.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Administrator on 2015-3-23.
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;

    private final String text;

    public BlackListEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public String getText() {
        return text;
    }
}
