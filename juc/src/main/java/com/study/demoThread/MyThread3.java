package com.study.demoThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yangz
 * @date 2021/12/16 - 13:54
 * 方式3:实现Callable接口功能
 * 区别：实现Callable接口的类有返回值 ,无法通过 Thread(new Runnable target)来启动线程
 */
public class MyThread3 implements Callable<String>{
    @Override
    public String call(){
        System.out.println("线程执行了3333");
        return "entry";
    }
}
class CallableTest{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask= new FutureTask(new MyThread3());

        new Thread(futureTask,"A").start();

        System.out.println(futureTask.get());

    }

}
