package com.study.single;

/**
 * @auther shkstart
 * @create 2021-12-06-8:56
 * 饿汉式单例2
 */
class Hungry2 {

    //1.私有化构造器，外部无法new
    private Hungry2() {
        HUNGRY=new Hungry2();
    }

    //2.内部创建对象实例 私有化 不可改变 类变量
    private  static Hungry2  HUNGRY;

    public static Hungry2 getInstance(){
        return HUNGRY;
    }
}