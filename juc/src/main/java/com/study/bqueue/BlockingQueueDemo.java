package com.study.bqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author yangz
 * @date 2021/12/17 - 11:11
 * 集合队列
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueueDemo.test4();
    }

    /*会抛出异常*/
    public static void test1(){
        //创建队列,并设置队列大小
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //.add 添加成功返回true
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println("=============");
        //返回对首元素, 队列为空报异常
        System.out.println(blockingQueue.element());

        //IllegalStateException: Queue full 添加元素超过队列大小时
        //System.out.println(blockingQueue.add("e"));

        //.remove 返回移除元素
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());


        //NoSuchElementException 当队列为空,移除元素时
        System.out.println(blockingQueue.remove());

    }
    /*有返回值 不会抛出异常*/
    public static void test2() {
        //创建队列,并设置队列大小
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //.offer 添加成功返回true
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        //添加元素超过队列大小时  返回false
        System.out.println(blockingQueue.offer("d"));
        System.out.println("=============");

        //返回对首元素, 队列为空返回null
        System.out.println(blockingQueue.peek());

        //.poll 返回移除元素
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        //当队列为空,移除元素时,返回false
        System.out.println(blockingQueue.poll());
    }

    /*等待阻塞*/
    public static void test3() throws InterruptedException {
        //创建队列,并设置队列大小
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //.put 添加元素 添加超过队列大小的元素时,会一直阻塞等待
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
       // blockingQueue.put("d"); 队列与满时,会一直阻塞等待

        //.take 返回队首元素
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

        //System.out.println(blockingQueue.take());队列已为空,获取会一直阻塞等待


    }
    /*等待阻塞的时间*/
    public static void test4() throws InterruptedException {
        //创建队列,并设置队列大小
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        //向队列中添加元素, 如何队列与满,会阻塞等待3秒,仍没有位置就退出
        System.out.println(blockingQueue.offer("d",3, TimeUnit.SECONDS));

        System.out.println("====================");

        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        //移除队列中的元素,如何队列为空,会阻塞等待3秒,仍没有元素进入就退出
        System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));

    }
}
