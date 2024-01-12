package com.study.demoLock.demo1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangz
 * @date 2021/12/15 - 11:45
 */
public class Ticket {
    private int number = 30;

    /**
     * 创建可重入锁
     */
    private final ReentrantLock lock = new ReentrantLock();

    public void sell() {
        //上锁
        lock.lock();

        try {
            if (number > 0) {
                System.out.print("线程名：" + Thread.currentThread().getName());
                System.out.println(" 卖第：" + (number--) + "还剩下 ：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }

    }
}
