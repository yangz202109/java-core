package com.study.proxy.dynamic_proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @author yangz
 * @date 2022/12/26 - 11:26
 */
public class MyMethodInterceptor implements MethodInterceptor {
    /**
     * @param o           cglib的代理对象
     * @param method      被代理对象方法
     * @param objects     方法入参
     * @param methodProxy 代理方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强前---");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("增强后---");
        return object;
    }
}
