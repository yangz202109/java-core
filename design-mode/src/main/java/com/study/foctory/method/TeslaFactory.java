package com.study.foctory.method;

import com.study.foctory.simple.Car;

/**
 * @auther shkstart
 * @create 2021-12-04-8:55
 * (特斯拉)工厂类
 */
public class TeslaFactory implements CarFactory{
    public Car getCar() {
        return new Tesla();
    }
}
