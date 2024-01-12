package com.study.single;

/**
 * @auther shkstart
 * @create 2021-12-04-10:38
 * 饿汉式单例1
 */
public class Hungry1 {

    //1.私有化构造器，外部无法new
    private Hungry1() {
    }

    //2.内部创建对象实例 私有化 不可改变 类变量
   private final static Hungry1  HUNGRY=new Hungry1();

   public static Hungry1 getInstance(){
        return HUNGRY;
   }
}



