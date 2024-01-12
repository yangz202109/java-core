package com.study.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @author yangz
 JSONObject  代表 json 对象
 JSONArray   代表 json 对象数组
 JSON        代表 JSONObject和JSONArray的转化
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        //创建一个对象
        Dog dog1 = new Dog("小黑", 8, 'm');
        Dog dog2 = new Dog("小白", 5, 'w');
        Dog dog3 = new Dog("小花", 2, 'w');
        Dog dog4 = new Dog("小黄", 6, 'm');

        //创建json对象，并赋值
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("k1","v1");
        jsonObject.put("k2","v2");

        Map<String ,Object> maps=new HashMap<String, Object>();
        maps.put("t1","n1");
        maps.put("t2","n2");
        String mapJson = JSON.toJSONString(maps);

        List<Dog> lists=new ArrayList<Dog>();
        lists.add(dog1);
        lists.add(dog2);
        lists.add(dog3);
        lists.add(dog4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(lists);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(dog1);
        System.out.println("JSON.toJSONString(dog1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        Dog dog = JSON.parseObject(str2, Dog.class);
        System.out.println("JSON.parseObject(str2,Dog.class)==>"+dog);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(dog2);
        System.out.println("(JSONObject) JSON.toJSON(dog2)==>"+jsonObject1.getIntValue("age"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        Dog dogOject = JSON.toJavaObject(jsonObject1, Dog.class);
        System.out.println("JSON.toJavaObject(jsonObject1,Dog.class)==>"+dogOject);

        System.out.println("================");
        System.out.println(mapJson);

    }

}
