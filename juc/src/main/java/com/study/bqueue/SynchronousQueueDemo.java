package com.study.bqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yangz
 * @date 2021/12/17 - 15:24
 * 同步队列:
 *  与其他BlockingQueue的实现类 不一样   SynchronousQueue 不储存元素
 *   put一个元素,必须从队列中take取出来,否则不能再put值进去
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
    //创建同步队列
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        //创建AA线程添加数据
        new Thread( ()->{
            try {
                System.out.println(Thread.currentThread().getName()+" 添加 a1");
                queue.put("a1");
                System.out.println(Thread.currentThread().getName()+" 添加 a2");
                queue.put("a2");
                System.out.println(Thread.currentThread().getName()+" 添加 a3");
                queue.put("a3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        //创建BB线程取出数据
        new Thread( ()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"--a1");
                queue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"--a2");
                queue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"--a3");
                //queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}

