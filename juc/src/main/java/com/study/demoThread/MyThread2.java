package com.study.demoThread;

/**
 * @author yangz
 * @date 2021/12/15 - 9:32
 * 方式2:实现Runnable接口的类就成为一个线程类
 *   但是无法直接启动 .start() 必须通过Thread类启动
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程执行了2222");
    }
}

class RunnableTest {
    public static void main(String[] args) {
        new Thread(new MyThread2()).start();
    }
}