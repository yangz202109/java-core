package com.study.nio.nio;

import java.nio.IntBuffer;

/**
 * @author yangz
 * @date 2022/8/26 - 11:19
 */
public class BasicBuffer {
    public static void main(String[] args) {
        //创建buffer,大小为3,可以存放3个int
        IntBuffer buffer = IntBuffer.allocate(3);

        //向buffer中存入数据
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i * 2);
        }

        //从buffer中读取数据
        //将buffer转换,读写切换
        buffer.flip();

        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

    }
}
