package com.study.foctory.simple;

/**
 * @auther shkstart
 * @create 2021-12-03-17:39
 * 顾客类
 */
public class Consumer {

    public static void main(String[] args) {
//        Car car1 = new Bmv();
//        Car car2=new Tesla();
//

        //从工厂中拿
        Car car1 = CarFactory.getCar("宝马");
        car1.name();
        Car car2 = CarFactory.getCar("特斯拉");
        car2.name();

    }
}
