package com.study.foctory.abstract1;

/**
 * @auther shkstart
 * @create 2021-12-04-9:48
 * 小米工厂
 */
public class MiFactory implements Factory {

    public Phone MakePhone() {
        return new MiPhone();
    }

    public Router MakeRouter() {
        return new MiRouter();
    }
}
