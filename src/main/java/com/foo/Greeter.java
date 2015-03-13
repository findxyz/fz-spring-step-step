package com.foo;

import java.util.Map;

/**
 * Created by Administrator on 2015-3-6.
 */

public class Greeter {

    private String helloWorld;

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    private Map<String, Float> accounts;

    public Map<String, Float> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Float> accounts) {
        this.accounts = accounts;
    }

    public String sayHello(){
        return "Greeter says Hello world!";
    }

}
