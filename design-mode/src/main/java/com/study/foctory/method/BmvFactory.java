package com.study.foctory.method;

import com.study.foctory.simple.Car;

/**
 * @author yangz
 * @create 2021-12-04-8:54
 * (宝马)工厂类
 */
public class BmvFactory implements CarFactory{
    public Car getCar() {
        return new Bmv();
    }
}
