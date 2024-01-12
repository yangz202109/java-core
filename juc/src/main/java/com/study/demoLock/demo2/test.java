package com.study.demoLock.demo2;

/**
 * @author yangz
 * @date 2021/12/15 - 16:07
 */
public class test {
    public static void main(String[] args) {
        Share share = new Share();

        new Thread(() ->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(() ->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
