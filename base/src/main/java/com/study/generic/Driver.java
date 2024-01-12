package com.study.generic;


/**
 * @author yangz
 * @date 2022/12/30 - 14:19
 */
public class Driver<T extends Car>{
  private T t;

    public Driver(T t) {
        this.t = t;
    }

    public void drive(){
        t.drive();
    }
}
