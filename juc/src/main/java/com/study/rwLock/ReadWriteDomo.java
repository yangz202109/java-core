package com.study.rwLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁：一次只能有一个线程占用(写锁,可重入锁,synchronized)
 * 共享锁：多个线程可以同时占用(读锁)
 */
public class ReadWriteDomo {

    public static void main(String[] args) {
        MyCacheLock cache = new MyCacheLock();
        // MyCache cache = new MyCache();

        //创建五条线程做写入操作
        for (int i = 1; i <= 5; i++) {
            int tem = i;
            new Thread(() -> {
                cache.put(tem + "", tem + "");
            }, String.valueOf(i)).start();
        }
        //创建五条线程做读取操作
        for (int i = 1; i <= 5; i++) {
            int tem = i;
            new Thread(() -> {
                cache.get(tem + "");
            }, String.valueOf(i)).start();
        }
    }

}

/*自定义缓存
 * 有问题:(未加锁) 多线程抢夺占用(并发)
 * */
class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    //写,存
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + " 写入：" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "--写入ok ");
    }

    //读,取
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + " 读出:" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "--读出ok");
    }
}

/*
 加锁 保证多线程下执行读写操作
  ReadWriteLock读写锁:  (适用条件是同一个数据，有大量线程读取，但仅有少数线程修改)
     1.写锁 只允许一个线程写入（其他线程既不能写入也不能读取）
     2.读锁 没有写入时，多个线程允许同时读（提高性能）
     3.读的操作会保证在写操作之后执行
     4.读写操作不能同时进行(同一线程). 及读写互斥,读读共享
 */
class MyCacheLock {
    //数据
    private volatile Map<String, Object> map = new HashMap<>();
    //使用读写锁 更精准控制
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //写,存时. 并发下只希望同时只有一个线程可以写,且过程中不可被其他线程插队
    public void put(String key, Object value) {
        readWriteLock.writeLock().lock(); //加写锁

        try {
            System.out.println(Thread.currentThread().getName() + " 写入：" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "----写入ok ");
        } finally {
            readWriteLock.writeLock().unlock(); //释放写锁
        }
    }

    //读,取(允许多个线程同时进行读取操作)
    public void get(String key) {
        readWriteLock.readLock().lock();//加入读锁
        try {
            System.out.println(Thread.currentThread().getName() + " 读出：" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "----读出ok");
        } finally {
            readWriteLock.readLock().unlock();//解开入读锁
        }
    }
}