package com.study.assist;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author yangz
 * Semaphore: 一个计数信号量
 * acquire()：从该信号量获取许可证，或等待直到可用
 * 抢停车位 6俩车, 3个停车位
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //创建Semaphore, 设置许可数量
        Semaphore semaphore = new Semaphore(3);

        //模拟6俩车
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {

                try {
                    //抢车位 占用一个许可(如何许可数量已经满了,就会等待直到可用)
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + " 抢到了车位");

                    //设置停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    //离开车位
                    System.out.println(Thread.currentThread().getName() + "------离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放占用的许可(释放许可证，将其返回到信号量。)
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }
    }
}
