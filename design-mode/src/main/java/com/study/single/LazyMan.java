package com.study.single;

/**
 * @auther yangz
 * @create 2021-12-04-10:42
 * 懒汉式单例1 线程不安全
 */
public class LazyMan {
    private static LazyMan lazyMan;

    private LazyMan() {
    }


    //调用方法时创建实例
   public static LazyMan getInstance(){
        if (lazyMan==null){
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }

}
