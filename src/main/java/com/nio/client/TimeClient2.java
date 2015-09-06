package com.nio.client;

/**
 * Created by Administrator on 2015/9/5.
 */
public class TimeClient2 {

    public static void main(String[] args){
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        new Thread(new AsyncTimeClientHandler("127.0.01", port), "AIO-AsyncTimeClientHandler-001").start();
    }
}
