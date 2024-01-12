package com.study.demoLock.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangz
 * @date 2021/12/15 - 14:18
 * 资源类
 */
public class Share {
    /**
     * 初始值
     */
    private int sum = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    /**
     * 递增
     * 加1方法 当sum等于0时执行
     */
    public void incr() throws InterruptedException {
        //加锁
        lock.lock();
        try {
            while (sum != 0) {
                condition.await();//等待
            }
            sum++;
            System.out.println(Thread.currentThread().getName() + " : " + sum);
            condition.signalAll(); //// 通知其他线程，我+1完毕了

        } finally {
            //解锁
            lock.unlock();
        }


    }

    //减1方法 当sum不等于0时执行
    public void decr() throws InterruptedException {
        //加锁
        lock.lock();
        try {
            while (sum == 0) {
                condition.await();//等待
            }
            sum--;
            System.out.println(Thread.currentThread().getName() + " : " + sum);
            condition.signalAll(); //通知

        } finally {
            //解锁
            lock.unlock();
        }
    }

}


