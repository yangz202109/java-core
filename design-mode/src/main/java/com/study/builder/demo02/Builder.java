package com.study.builder.demo02;

//抽象建造者
public abstract class Builder {

    //提供套餐
    abstract Builder builderA(String msg);//可乐
    abstract Builder builderB(String msg);//薯条
    abstract Builder builderC(String msg);//汉堡
    abstract Builder builderD(String msg);//炸鸡

    //返回一个产品
    abstract Product getProduct();
}
