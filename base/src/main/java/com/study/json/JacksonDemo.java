package com.study.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author yangz
 * @date 2021/12/8 - 14:15
 */
public class JacksonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();

        //创建一个java实体类
        Dog dog = new Dog("花花", 5, 'w');
        //将我们的对象解析成为json格式 writeValueAsString中的参数(String,javaBean,Date,List)都转成jsonString
        String str = mapper.writeValueAsString(dog);
        System.out.println(str);
    }
}
