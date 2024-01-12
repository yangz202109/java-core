package com.study.proxy.static_proxy.jdk;

/**
 * @author yangz
 * @date 2022/12/26 - 9:38
 * 被代理类
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void work() {
        System.out.println("user is working");
    }
}
