package com.study.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *Function 函数型接口
 */
public class Demo01 {
    public static void main(String[] args) {
       /* Function<String,String> function = new Function<String,String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };*/
        Function<String,String> function =(str)-> str;
        System.out.println(function.apply("aaaa"));


      /*  Predicate<String> predicate=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };*/
        Predicate<String> predicate=(str)-> str.isEmpty();
        System.out.println(predicate.test(""));
/*
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s="+s);
            }
        };*/
        Consumer<String> consumer=(s)-> System.out.println("s="+s);
        consumer.accept("hello");

       /* Supplier<String> supplier=new Supplier<String>() {
            @Override
            public String get() {
                return "hello,world";
            }
        };*/
        Supplier<String> supplier=()-> "hello,world";
        System.out.println(supplier.get());
    }
}
