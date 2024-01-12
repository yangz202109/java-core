package com.study.adapter;

/**
 *  真正的适配器   连接usb ，连接网线
 * @author yangz
 */
public class Adapter extends Adaptee implements NetToUsb{


    public void handleRequester() {
        super.request();//可以上网了
    }
}
