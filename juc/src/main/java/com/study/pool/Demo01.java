package com.study.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangz
 * @date 2021/12/17 - 16:30
 * Executors 工具类、3大方法
 * Executors创建线程池
 */
public class Demo01 {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程 1池1线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建一个固定的线程池的大小 1池多线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的线程池

        /*
         * 线程并不会立刻创建
         * 在执行.execute(...) 时就会创建线程
         * */
        try {
            for (int i = 1; i <= 10; i++) {
                //通过线程池创建线程
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "进入"));
            }

        } finally { //保证一定会关
            //线程池用完及关
            threadPool.shutdown();
        }
    }
}
/* * 线程池内部维护了若干个线程，没有任务的时候，这些线程都处于等待状态。
 * 如果有新任务，就分配一个空闲线程执行。如果所有线程都处于忙碌状态，
 * 新任务要么放入队列等待，要么增加一个新线程进行处理。
 * */