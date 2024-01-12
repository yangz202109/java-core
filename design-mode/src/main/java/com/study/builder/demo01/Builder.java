package com.study.builder.demo01;

//抽象建造者(能力)
public abstract class Builder {

    abstract void build1();//打地基
    abstract void build2();//建墙体
    abstract void build3();//粉刷

    abstract Product getProduct();
}
