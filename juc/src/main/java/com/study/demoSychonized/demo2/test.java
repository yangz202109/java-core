package com.study.demoSychonized.demo2;

/**
 * @author yangz
 * @date 2021/12/15 - 14:30
 */
public class test {
    public static void main(String[] args) {
        Share share=new Share();

        //创建线程
        new Thread( () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    share.decr();   //减1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"AA").start();

        //创建线程
        new Thread( () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    share.incr();  //加1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"BB").start();
    }
}
