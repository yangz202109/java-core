package com.study.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用ThreadPoolExecutor来创建线程池
 * ThreadPoolExecutor的七个参数
 * int corePoolSize,       核心线程池大小(常驻线程数量)
 * int maximumPoolSize,    最大核心线程池大小/最大线程数量 (默认最大可以达到21亿)
 * long keepAliveTime,     超时了没有人调用就会释放(线程的存活时间)
 * TimeUnit unit,         时间单位
 * BlockingQueue<Runnable> workQueue,  阻塞队列
 * ThreadFactory threadFactory,  线程工厂：创建线程的，一般不用动
 * RejectedExecutionHandler handler{...} 拒绝策略(如何在满的情况下处理进入的)
 * 四种处理策略:
 * 1.  new ThreadPoolExecutor.AbortPolicy() 不处理,抛异常
 * 2.  new ThreadPoolExecutor.CallerRunsPolicy()  哪里来回哪里去
 * 3.  new ThreadPoolExecutor.DiscardPolicy()  不处理,不抛异常
 * 4.  new ThreadPoolExecutor.DiscardOldestPolicy()  让当前任务尝试与等待最久的任务竞争,成功,则抛弃原任务来执行当前任务
 */
public class Demo02 {
    public static void main(String[] args) {
        //使用ThreadPoolExecutor创建线程池
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,  //平常银行前台数量
                5,  //最大银行前台数量,在候客区满了的情况下,开启
                3,  //开启的最大银行前台数在指定时间后,没有人来就关闭
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),//银行候客区
                Executors.defaultThreadFactory(),  //默认 ==
                //不处理,抛异常
                new ThreadPoolExecutor.DiscardOldestPolicy()); //银行已经满了(最大银行前台数量和候客区),还有人进来

        /*
         * 线程池的最大承载 : 最大核心线程池+ 阻塞队列 5+3
         * */
        try {
            //10个顾客进入银行,要求服务
            for (int i = 1; i <= 10; i++) {
                int temp = i;
                //通过线程池创建线程,将任务添加到线程池
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "处理" + temp + "号用户");
                });
            }

        } finally { //保证一定会关
            //线程池用完及关
            threadPool.shutdown();
        }
    }
}
