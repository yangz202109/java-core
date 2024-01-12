package com.study.assist;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author yangz
 * CyclicBarrier: 允许一组线程全部等待彼此达到共同屏障点的同步辅助。
 * 搜集七颗龙珠召唤神龙
 */

public class CyclicBarrierDemo {
    /**
     * 设置固定值
     */
    private static final int SUM = 7;

    public static void main(String[] args) {

        //创建CyclicBarrier,达到数量,自动执行线程
        CyclicBarrier barrier = new CyclicBarrier(SUM, () -> {
            System.out.println("你已经搜集七颗龙珠,可以召唤神龙");
        });

        for (int i = 1; i <= SUM; i++) {
            int sum = i;

            new Thread(() -> {

                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "搜集到" + sum + "星龙珠");
                    //等待 i=SUM时
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }, String.valueOf(i)).start();
        }

    }
}
