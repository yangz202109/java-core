package com.study.foctory.abstract1;

/**
 * @auther shkstart
 * @create 2021-12-04-9:45
 * 抽象产品工厂
 */
public interface Factory {
    //生成手机
    Phone MakePhone();
    //生成路由器
    Router MakeRouter();

}
