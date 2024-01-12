package com.study.foctory.abstract1;

/**
 * @auther shkstart
 * @create 2021-12-04-9:49
 */
public class HuanweiFactory implements Factory {

    public Phone MakePhone() {
        return new HuaweiPone();
    }

    public Router MakeRouter() {
        return new HuaweiRouter();
    }
}
