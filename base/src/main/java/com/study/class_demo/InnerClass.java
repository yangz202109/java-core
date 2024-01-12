package com.study.class_demo;

/**
 * @author yangz
 * @date 2022/12/26 - 16:34
 * 成员内部类
 * 定义在类内部,成员位置上的非静态类,就是成员内部类。
 */
public class InnerClass {
    private static int radius = 1;
    private int count = 2;

    class Inner {
        public void visit() {
            System.out.println("visit outer static variable:" + radius);
            System.out.println("visit outer  variable:" + count);
        }
    }
}
class Main2{
    public static void main(String[] args) {
        //成员内部类可以访问外部类所有的变量和方法,包括静态和非静态,私有和公有.成员内部类依赖于外部类的实例,它的创建方式外部类实例.new 内部类()
        InnerClass innerClass = new InnerClass();
        InnerClass.Inner inner = innerClass.new Inner();
        inner.visit();
    }
}
