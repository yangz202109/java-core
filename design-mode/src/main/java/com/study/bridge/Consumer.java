package com.study.bridge;

/**
 * @auther shkstart
 * @create 2021-12-06-14:42
 */
public class Consumer {
    public static void main(String[] args) {
        Computer computer=new Laptop(new Huawei());
        computer.info();
        Computer computer2 = new Destktop(new Apple());
        computer2.info();
    }



}
