package com.study.builder.demo01;

//事件的建造者 工人
public class Worker extends Builder {
    private Product product;

    public Worker() {
        product=new Product();
    }

    void build1() {
        product.setProcedure1("打地基");
        System.out.println("打地基");
    }

    void build2() {
        product.setProcedure2("建墙体");
        System.out.println("建墙体");
    }

    void build3() {
        product.setProcedure3("粉刷");
        System.out.println("粉刷");
    }

    Product getProduct() {
        return product;
    }
}
