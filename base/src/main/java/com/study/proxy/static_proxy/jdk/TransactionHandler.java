package com.study.proxy.static_proxy.jdk;

/**
 * @author yangz
 * @date 2022/12/26 - 9:39
 * 代理类-->增强被代理类work方法
 */
public class TransactionHandler implements UserDao{
    /**代理目标对象*/
    private UserDao target;

    /**构造代理对象的代理类*/
    public TransactionHandler(UserDao target) {
        this.target = target;
    }

    @Override
    public void work() {
        System.out.println("增强方法:user is eating");
        //调用目标的方法
        target.work();
        System.out.println("增强方法:user has worked");
    }
}
