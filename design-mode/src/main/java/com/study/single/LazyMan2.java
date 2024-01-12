package com.study.single;

/**
 * @auther yangz
 * @create 2021-12-06-8:58
 * 懒汉式单例2 双重检测
 */
public class LazyMan2 {

    private static volatile LazyMan2 instance;


    private LazyMan2() {
    }

    public static synchronized LazyMan2 getInstance(){
        if (instance==null){//判断1
            synchronized (LazyMan2.class){//对象锁
                if (instance==null){//判断2
                    instance=new LazyMan2();
                }
            }
        }
        return instance;
    }

}
