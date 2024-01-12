package com.study.class_demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author yangz
 * @date 2022/12/26 - 16:27
 * 静态内部类
 * 定义在类内部的静态类，就是静态内部类。
 */
public class StaticInnerClass {
    private static  int radius =1;
    static class  StaticInner{
        public void visit(){
            System.out.println("visit out static variable:"+radius);
        }
    }
}
class Main{
    public static void main(String[] args) {
        //静态内部类可以访问外部类所有的静态变量,而不可访问外部类的非静态变量; 静态内部类的创建方式,new 外部类.静态内部类()
        StaticInnerClass.StaticInner inner = new StaticInnerClass.StaticInner();
        inner.visit();

        LocalDate now = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println(now);
        System.out.println(dtf.format(now).substring(2));
    }
}