package com.thread;

import java.util.concurrent.*;

/**
 * Created by win7 on 2015/6/2.
 */
public class JavaThreadPoolMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Executors.newFixedThreadPool(3) ���ֻ������ͬʱ�����������˾���������һ�����߳�������ͽ���
        // Executors.newSingleThreadExecutor() �κ�ʱ��ֻ��һ���̣߳�����˳��ִ���̣߳��������������һ���µģ��������������ã�������ͽ���
        // Executors.newCachedThreadPool() ����һ�����Ի���60����̳߳أ�����Ҫ�ȴӻ�����л�ȡ������ز���ʱ���´����̣߳����������ִ������߳�
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0; i<10; i++){
            System.out.println(i);
            // Runnable ��û�з���ֵ���߳�
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
        // Callable �����з���ֵ��ͨ��Future����������
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
