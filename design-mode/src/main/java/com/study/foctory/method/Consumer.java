package com.study.foctory.method;

import com.study.foctory.simple.Car;

import java.util.HashMap;

/**
 * @auther shkstart
 * @create 2021-12-03-17:39
 * 顾客类
 */
public class Consumer {

    public static void main(String[] args) {
//        Car car1 = new Bmv();
//        Car car2=new Tesla();

        //从工厂中拿
        BmvFactory bmvFactory = new BmvFactory();
        Car car1 = bmvFactory.getCar();

        Car car2 = new TeslaFactory().getCar();

        car1.name();
        car2.name();

        HashMap<String, Integer> map = new HashMap<>();
        map.put("one",12);
        map.put("tow",2444);

    }
}
