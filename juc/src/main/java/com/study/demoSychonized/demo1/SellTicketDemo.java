package com.study.demoSychonized.demo1;

/**
 * @author yangz
 * @date 2021/12/15 - 10:14
 * 测试类
 */
public class SellTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 1; i <= 30; i++) {
                ticket.sell();
            }
        }, "A").start();

        Thread thread = new Thread(ticket::sell, "B");
        thread.start();

        new Thread(ticket::sell, "C").start();
    }
}
