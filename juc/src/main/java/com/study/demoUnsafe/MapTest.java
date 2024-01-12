package com.study.demoUnsafe;


import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangz
 * @date 2021/12/16 - 13:39
 */
public class MapTest {
    public static void main(String[] args) {
        /*ConcurrentModificationException
         *解决方法：
         * 1.Collections.synchronizedMap(new HashMap<>());
         * 2.new ConcurrentHashMap<>();
         * */

        Map<String,String> map=new ConcurrentHashMap<>();
        for (int i = 1; i <20; i++) {
            int finalI = i;

            new Thread( ()->{
               map.put(String.valueOf(finalI),UUID.randomUUID().toString().substring(0,3));
                System.out.println(map);

            },String.valueOf(i)).start();
        }
    }
}
