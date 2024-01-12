package com.study.reflect;

import java.lang.reflect.Field;

/**
 * 使用反射操作成员变量
 * @author yangz
 */
public class FieldDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        //得到Person类的Class类
        Class Pclass = Class.forName("com.study.Person");
       //显示的是哪个类的Class对象
        System.out.println(Pclass);

        //通过反射得到Person类成员变量
        // .getFields()和.getField只能获取到public修饰的成员变量
        Field[] fields = Pclass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field name = Pclass.getField("name");
        System.out.println(name);


    }
}
