package com.study.builder.demo02;

//服务员 ： 具体的生产者
public class Waiter extends Builder{
    private Product product;

    public Waiter() {
        product=new Product();
    }


    Builder builderA(String msg) {
        product.setA(msg);
        return this;//本类

    }

    Builder builderB(String msg) {
        product.setB(msg);
        return this;
    }

    Builder builderC(String msg) {
        product.setC(msg);
        return this;
    }

    Builder builderD(String msg) {
        product.setD(msg);
        return this;
    }

    Product getProduct() {
        return product;
    }
}
