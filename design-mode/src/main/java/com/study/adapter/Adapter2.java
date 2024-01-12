package com.study.adapter;

/**
 * 真正的适配器  连接usb ,连接网线
 * @author yangz
 */
public class Adapter2 implements NetToUsb{
    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void handleRequester() {
            adaptee.request();
    }
}
