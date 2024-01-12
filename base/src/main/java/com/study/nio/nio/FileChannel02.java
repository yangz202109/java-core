package com.study.nio.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yangz
 * @date 2022/8/29 - 14:56
 * 使用nio将文件读取程序
 */
public class FileChannel02 {
    public static void main(String[] args) throws IOException {
        //创建文件输入流-->channel
        File file = new File("E:\\tmp\\t.txt");
        FileInputStream inputStream = new FileInputStream(file);

        //通过流获取通道
        FileChannel fileChannel = inputStream.getChannel();

        //创建缓存区-根据文件长度
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //从该通道读取到给定缓冲区的字节序列
        fileChannel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));

        //关闭流
        inputStream.close();
    }
}
