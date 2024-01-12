package com.study.adapter;

/**
 客服端：想上网，插不上网线~
 */
public class Computer {

    public void net(NetToUsb netToUsb){
        //上网的具体实现 使用转接器
        netToUsb.handleRequester();
    }

    public static void main(String[] args) {
        //上网 电脑 ，适配器，网线
        Computer computer = new Computer();
        Adaptee adaptee = new Adaptee();
        Adapter2 adapter2 = new Adapter2(adaptee);

        computer.net(adapter2);

    }
}
