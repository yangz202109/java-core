package com.study.generic;

/**
 * @author yangz
 * @date 2022/12/30 - 14:29
 * 泛型类测试
 */
public class Main {
    public static void main(String[] args) {
        Driver<Car> driver = new Driver<>(new Alto());
        driver.drive();

    }
}
