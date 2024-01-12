package com.study.demoSychonized.demo2;

/**
 * @author yangz
 * @date 2021/12/15 - 14:18
 * 资源类
 * 锁对象.wait(); 导致当前线程等,，直到另一个线程调用该对象的 notify()方法或 notifyAll()方法。
 * notify() 唤醒正在等待对象监视器的单个线程。
 * notifyAll() 唤醒正在等待对象监视器的所有线程。
 */
public class Share {
    /**
     * 初始值
     */
    private int sum = 0;

    //加1方法 当sum等于0时执行
    public synchronized void incr() throws InterruptedException {
        while (sum != 0) {     //if (sum != 0) 会出现虚假唤醒
            this.wait(); //等待其他线程执行,并释放锁
        }
        sum++;
        System.out.println(Thread.currentThread().getName() + " : " + sum);

        //通知其他线程(因为该方法时唤醒其他相同锁对象的线程)
        this.notifyAll();
    }

    //减1方法 当sum不等于0时执行
    public synchronized void decr() throws InterruptedException {
        while (sum == 0) { //但sum不为0时执行进程
            this.wait(); //该线程进入等待,并释放锁
        }
        sum--;
        System.out.println(Thread.currentThread().getName() + " : " + sum);
        //通知其他线程,本线程已经释放锁
        this.notifyAll();
    }
}


