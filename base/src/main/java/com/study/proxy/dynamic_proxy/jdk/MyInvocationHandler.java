package com.study.proxy.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yangz
 * @date 2022/12/26 - 9:54
 */
public class MyInvocationHandler implements InvocationHandler {
    /**目标对象*/
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强--前逻辑");
        //执行目标的方法
        Object rs = method.invoke(target, args);
        System.out.println("增强--后逻辑");
        return rs;
    }
}
