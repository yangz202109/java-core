package com.study.nio.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yangz
 * @date 2022/8/29 - 14:07
 * 使用nio将数据写人文件
 */
public class FileChannel01 {
    public static void main(String[] args) throws IOException {
        //数据
        String data = "hello,world this is monday";
        //创建文件输出流-->channel
        FileOutputStream outputStream = new FileOutputStream("E:\\tmp\\t.txt");

        //通过流获取通道
        FileChannel fileChannel = outputStream.getChannel();

        //创建缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将数据放人缓存区
        byteBuffer.put(data.getBytes());

        //反转缓冲区(让position指向最前面)
        byteBuffer.flip();

        //将缓冲区的数据写入channel
        fileChannel.write(byteBuffer);

        //关闭流
        outputStream.close();

    }
}
