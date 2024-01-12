package com.study.assist;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangz
 *  CountDownLatch : 允许一个或多个线程等待直到在其他线程中执行的一组操作完成的同步辅助。
 *  countDown() :   减少锁存器的计数，如果计数达到零，释放所有等待的线程
 *
 *等待6位同学离开后,老师就关门
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建计数器设置初始值 6
        CountDownLatch latch = new CountDownLatch(6);

        //6名同学离开后,锁门(结束计数)
        for (int i = 1; i <=6; i++) {
            new Thread( ()->{

              System.out.println(Thread.currentThread().getName()+ " go out");

              latch.countDown(); //出去一个就减少计数
            },String.valueOf(i) ).start();
        }

        latch.await(); //计数为零自动唤醒,就向下执行
        System.out.println(Thread.currentThread().getName()+" Close Door");
    }
}
