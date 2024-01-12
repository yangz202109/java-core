package com.study.demoThread;

/**
 * @author yangz
 * @date 2021/12/15 - 9:27
 * 方式1:继承Thread的类就成为一个线程类,可以直接启动 .start();
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 线程启动了");
    }
}

class ThreadTest{
    public static void main(String[] args) {
        System.out.println("主线程启动了");
         new MyThread().start();
        System.out.println("主线程完成");
    }
}
