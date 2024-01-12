package com.study.proxy.static_proxy.jdk;

/**
 * @author yangz
 * @date 2022/12/26 - 9:45
 * 基于jdk的静态代理
 */
public class Main {
    public static void main(String[] args) {
        UserDaoImpl target = new UserDaoImpl();
        UserDao userDao = new TransactionHandler(target);
        userDao.work();
    }
}
