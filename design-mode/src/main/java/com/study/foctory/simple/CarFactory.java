package com.study.foctory.simple;

/**
 * @author yangz
 * @create 2021-12-03-17:42
 * 工厂类
 * 静态工厂模式
 * 当增加一个新产品时，需要改动源代码，违反开闭原则
 */
public class CarFactory {

    public static Car getCar(String car){
        if ("宝马".equals(car)){
            return new Bmv();
        }else if("特斯拉".equals(car)){
            return new Tesla();
        }
         return null;
    }
}
