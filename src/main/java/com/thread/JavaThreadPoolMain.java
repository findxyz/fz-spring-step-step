package com.thread;

import java.util.concurrent.*;

/**
 * Created by win7 on 2015/6/2.
 */
public class JavaThreadPoolMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Executors.newFixedThreadPool(3) 最多只有三个同时工作，出错了就重新启动一个，线程运行完就结束
        // Executors.newSingleThreadExecutor() 任何时候只有一个线程，按照顺序执行线程，出错就重新启动一个新的，不可以重新配置，运行完就结束
        // Executors.newCachedThreadPool() 启动一个可以缓存60秒的线程池，有需要先从缓存池中获取，缓存池不足时，新创建线程，出错了重现创建新线程
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0; i<10; i++){
            System.out.println(i);
            // Runnable 是没有返回值的线程
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            });
        }

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        // Callable 可以有返回值，通过Future对象来接收
        Future<String> future = executorService2.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(8000);
                return Thread.currentThread().getName() + " has been returned callable value";
            }
        });
        System.out.println(future.get());
        System.out.println("Is blocked ? The answer is yes");
    }
}
