package com.study.demoLock.demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangz
 * @date 2021/12/15 - 16:47
 * 资源类
 * 设置执行顺序 one->tow->three
 */
public class Order {
    private int num = 1;

    private final Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void one() {
        lock.lock();

        try {

            while (num != 1) {
                c1.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName() + " :执行 one ");

            num++;
            c2.signal();  //通知

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void two() {
        lock.lock();

        try {
            while (num != 2) {
                c2.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName() + " :执行 two ");

            num++;
            c3.signal();  //通知唤醒指定 three

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void three() {
        lock.lock();

        try {
            while (num != 3) {
                c3.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName() + " :执行 three");

            num = 1;
            c1.signal();  //通知

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
