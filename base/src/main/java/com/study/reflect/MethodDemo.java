package com.study.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yangz
 * @create 2021-11-16-15:18
 */
public class MethodDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //得到Person类的Class类
        Class Pclass = Class.forName("com.study.Person");
        //调用无参构造器，返回该Class对象的一个实例
        Object o = Pclass.newInstance();
        System.out.println(o);

        //通过反射得到Person类成员方法
        //.getMethods和.getMethod 只能获取到public修饰的成员方法
        /*Method[] methods =Pclass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/

        //得到action方法
        Method action = Pclass.getMethod("action");
        //反射执行action方法 ，比通过对象调用速度慢
        // action.invoke(o);

        //反射调用优化()  ==>关闭访问检测
        action.setAccessible(true); //在反射调用方法时，取消访问检测
    }

}
