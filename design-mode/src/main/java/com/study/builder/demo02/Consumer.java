package com.study.builder.demo02;

/**
 * @auther shkstart
 * @create 2021-12-06-10:53
 */
public class Consumer {
    public static void main(String[] args) {
        //服务员
        Waiter waiter = new Waiter();
        //要求服务员修改套餐
        waiter.builderA("雪碧")
              .builderB("牛排")
              .builderC("披萨")
              .builderD("甜点");

        Product product = waiter.getProduct();
        System.out.println(product);

    }
}
