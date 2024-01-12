package com.study.demoSychonized.demo1;

/**
 * @author yangz
 * @date 2021/12/15 - 10:07
 * 资源类
 * synchronized：解决了多线程并发,但并没有解决多线程协调的问题
 */

public class Ticket {
    private int number = 30;

    public synchronized void sell() {
        if (number > 0) {
            System.out.print("线程名：" + Thread.currentThread().getName());
            System.out.println(" 卖第：" + (number--) + "还剩下 ：" + number);
        }
    }
}
