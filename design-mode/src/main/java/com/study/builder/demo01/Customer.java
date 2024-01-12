package com.study.builder.demo01;

/**
 * @auther yangz
 * @create 2021-12-06-9:50
 */
public class Customer {
    public static void main(String[] args) {
        //指挥
        Director director = new Director();
        //指挥工人完成 产品
        Product build = director.build(new Worker());

        System.out.println(build.toString());


    }
}
