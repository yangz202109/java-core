package com.study.proxy.dynamic_proxy.cglib;

/**
 * @author yangz
 * @date 2022/12/26 - 11:17
 */
public class HelloService {

    public HelloService() {
        System.out.println("HelloService 构造");
    }

    /**
     * 该方法不能被子类重写,cglib是无法代理final修饰的方法的
     * @param name
     * @return
     */
    final public String chat(String name){
        System.out.println("HelloService:chat with "+ name);
        return null;
    }

    public void say(){
        System.out.println("HelloService:say");
    }
}
