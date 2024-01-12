package com.study.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangz
 * @create 2021-12-02-17:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    private String name;
    private int age;
    private char gender;
}
