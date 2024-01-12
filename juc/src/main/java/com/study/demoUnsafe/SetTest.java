package com.study.demoUnsafe;


import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @author yangz
 * @date 2021/12/16 - 11:26
 */
public class SetTest {
    public static void main(String[] args) {
        /*ConcurrentModificationException
        *解决方法：
        * 1.Collections.synchronizedSet(new HashSet<>());
        * 2.new CopyOnWriteArraySet<>();
        * */
        Set<String> set= new CopyOnWriteArraySet<>();

        for (int i = 1; i <20; i++) {
            new Thread( ()->{
                set.add(UUID.randomUUID().toString().substring(0,3));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
