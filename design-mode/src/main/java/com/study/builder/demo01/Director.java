package com.study.builder.demo01;

/**
 * 指挥
 */
public class Director {

    //指挥工人按照顺序建房子
    public Product build(Builder builder){
        builder.build1();

        builder.build3();

        builder.build2();
        return builder.getProduct();
    }
}
