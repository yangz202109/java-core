package com.study.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author yangz
 * @date 2021/12/16 - 9:14
 */
public class Phone2 {

    public synchronized void sendMsg() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-发短信");
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "-打电话");
    }

    public void hello() {
        System.out.println(Thread.currentThread().getName() + "-hello");
    }
}

class testPhone2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        Phone2 phone1 = new Phone2();

        new Thread(() -> phone.sendMsg(),
                "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> phone1.call(), "B").start();
    }
}
