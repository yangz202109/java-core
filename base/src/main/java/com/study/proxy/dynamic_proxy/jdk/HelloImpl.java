package com.study.proxy.dynamic_proxy.jdk;

/**
 * @author yangz
 * @date 2022/12/26 - 9:53
 */
public class HelloImpl implements IHello{
    @Override
    public void hello() {
        System.out.println("hello world");
    }
}
