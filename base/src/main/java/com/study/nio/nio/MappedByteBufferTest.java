package com.study.nio.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yangz
 * @date 2022/9/5 - 13:54
 * MappedByteBuffer:可以让文件在内存(堆外内存)中修改,操作系统不需要拷贝一次
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("E:\\tmp\\test\\6.txt", "rw");

        //获取对应的通道
        FileChannel fileChannel = accessFile.getChannel();

        /**
         * map方法:
         *  参数1： FileChannel.MapMode.READ_WRITE 使用读写模式
         *  参数2： 0  可以修改的起始位置
         *  参数3:  5  是映射到内存的大小
         */
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        String str = "12";
        mappedByteBuffer.put(str.getBytes());

        accessFile.close();
    }

}
