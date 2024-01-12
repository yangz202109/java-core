package com.study.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author yangz
 * @date 2021/12/15 - 19:34
 */
public class Phone {
    //synchronized 锁的对象 是方法的调用者 phone
    //两方法用的是同一把锁，谁先拿到谁执行

    public synchronized void sendMsg() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-在发短信");
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "-在打电话");
    }
}

class testPhone {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(phone::sendMsg, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(phone::call, "B").start();

    }
}
