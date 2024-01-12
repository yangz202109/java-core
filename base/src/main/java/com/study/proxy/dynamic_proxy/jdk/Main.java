package com.study.proxy.dynamic_proxy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author yangz
 * @date 2022/12/26 - 9:59
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*==================第一种=====================*/
        //1、生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //获取动态代理类
        Class proxyClass = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        //获取代理类的构造函数,并传入参数类型InvocationHandle.class
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        //通过构造函数来创建动态代理对象,将自定义InvocationHandler实例传入
        IHello iHello1 = (IHello) constructor.newInstance(new MyInvocationHandler(new HelloImpl()));
        iHello1.hello();

        /*==================第二种=====================*/
        IHello iHello2 = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),
                new Class[]{IHello.class},
                new MyInvocationHandler(new HelloImpl()));
        iHello2.hello();
    }
}
