package com.study.demoUnsafe;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yangz
 * @date 2021/12/16 - 9:48
 */
public class ArrayListTest {
    public static void main(String[] args) {
       /* ConcurrentModificationException
       * 方法一 :  List<String> list=new Vector();
       * 方法二 : 使用工具类 Collections.synchronizedList(new ArrayList<>());
       * 方法三:  List<String> list =new  CopyOnWriteArrayList<>();
        * */

        List<String> list =new  CopyOnWriteArrayList<>();


        for (int i = 0; i < 25; i++) {
            new Thread( ()->{
                list.add("**");
                System.out.println(list);
            },String.valueOf('a' + i)).start();
        }
    }

}