package com.study.nio.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yangz
 * @date 2022/8/29 - 15:40
 * 使用nio拷贝文件
 */
public class FileChannel03 {

    public static void main(String[] args) throws IOException {

        //创建文件输入流-->channel
        FileInputStream inputStream = new FileInputStream("E:\\tmp\\t.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();

        //创建文件输出流-->channel
        FileOutputStream outputStream = new FileOutputStream("E:\\tmp\\t111.txt");
        FileChannel outputStreamChannel = outputStream.getChannel();

        //创建缓存区(如何文件大小超过缓冲区大小就需要循环读取)
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        //将inputStreamChannel的数据读到的缓冲区
        inputStreamChannel.read(byteBuffer);

        //System.out.println(new String(byteBuffer.array()));
        byteBuffer.flip();

        //将缓冲区的数据写入outputStreamChannel
        outputStreamChannel.write(byteBuffer);

        //关闭流
        outputStream.close();
        inputStream.close();

    }
}
