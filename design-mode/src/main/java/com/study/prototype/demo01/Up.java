package com.study.prototype.demo01;

import java.util.Date;

/**
 客服端： 克隆(浅)
 */
public class Up {//up主

    public static void main(String[] args) throws CloneNotSupportedException {
        //原型对象
        Date date=new Date();
        Video v1 = new Video("JOJO",date);
        //克隆对象 v2
        Video v2 = (Video)v1.clone();

        System.out.println("v1=>" + v1);
        System.out.println("v2=>" + v2);
        System.out.println("===========================");

        date.setTime(29229);
        System.out.println("v1=>" + v1);
        System.out.println("v2=>"+v2);
//        System.out.println("v1=>hash:"+v1.hashCode());
//
//
//
//        System.out.println("v2=>hash:"+v2.hashCode());
    }
}
