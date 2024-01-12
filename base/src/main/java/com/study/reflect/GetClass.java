package com.study.reflect;

/**
 * 获取一个类的Class对象
 * @author yangz
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        /*第一种 Class.forName("全类名")
        源代码阶段,它能将字节码文件加载进内存中,然后返回 Class 对象,
        多用于配置文件中,将类名定义在配置文件中,通过读取配置文件来加载类.*/
        Class<?> Pclass = Class.forName("com.study.Person");
        
        //第二种 类对象阶段,通过类名的 class 属性来获取,多用于参数的传递。
        Class<Person> pclass2 = Person.class;
        
        //第三种 运行时阶段,getClass() 定义在 Object 类中
        //表明所有类都能使用该方法,多用于对象的获取字节码的方式.
        Person p=new Person();
        Class<?> pclass3 = p.getClass();

        //第四种 通过类加载器
        ClassLoader classLoader = p.getClass().getClassLoader();
        Class<?> pclass4 = classLoader.loadClass("com.study.Person");
        System.out.println(pclass4);

        Class<Integer> integerClass = Integer.TYPE;
        System.out.println(integerClass);

    }
}
