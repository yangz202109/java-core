package com.study.demoLock.demo3;

/**
 * @author yangz
 * @date 2021/12/15 - 16:56
 */
public class test {
    public static void main(String[] args) {
        Order order = new Order();

        new Thread(order::one,"AA").start();

        new Thread(order::two, "BB").start();

        new Thread(order::three,"CC").start();

    }
}
