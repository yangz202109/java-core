package com.study.foctory.abstract1;

/**
 * @auther shkstart
 * @create 2021-12-04-9:43
 * 抽象工厂模式
 */
public class Consumer {
    public static void main(String[] args) {
        MiFactory miFactory = new MiFactory();
        Phone phone = miFactory.MakePhone();
        Router router = miFactory.MakeRouter();

        phone.call();
        phone.listen();
        router.online();

        HuanweiFactory huanweiFactory = new HuanweiFactory();
        Phone phone2 = huanweiFactory.MakePhone();
        Router router2 = huanweiFactory.MakeRouter();

        phone2.call();
        phone2.listen();
        router2.online();

    }
}
