package com.study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yangz
 *
 * @create 2021-11-17-9:09
 */
public class FieldDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
       //1.得到Cat类的Class对象
        Class<Cat> catClass = Cat.class;
        //2.通过反射创建一个cat对象
        Cat cat = catClass.newInstance();

        //通过反射获取成员变量
        Field brand =catClass.getField("brand");
        //通过反射修改成员变量
        brand.set(cat,"宝马");

        //通过反射获取私有的成员变量
        Field id = catClass.getDeclaredField("id");
         //私有的成员变量无法修改,先爆破
        id.setAccessible(true);
        id.set(cat,1);

        //通过反射获取static的成员变量
        Field price = catClass.getDeclaredField("price");
        //私有的成员变量无法修改,先爆破
        price.setAccessible(true);
        price.set(null,300000);
        System.out.println(cat);

        //通过反射获取成员方法
        Method sell = catClass.getMethod("sell",double.class);
        sell.invoke(cat,5555555);

        //通过反射获私有的成员方法
        Method vip = catClass.getDeclaredMethod("vip");
        //私有的成员变量无法修改,先爆破
        vip.setAccessible(true);
        vip.invoke(cat);

    }
}
