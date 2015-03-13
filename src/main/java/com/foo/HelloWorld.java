package com.foo;

/**
 * Created by Administrator on 2015-3-6.
 */
import org.apache.log4j.Logger;
import org.joda.time.LocalTime;

public class HelloWorld {
    static Logger logger = Logger.getLogger(HelloWorld.class);

    private Greeter greeter;

    public Greeter getGreeter() {
        return greeter;
    }

    public void setGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    public static void main(String[] args){
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);
    }

}
