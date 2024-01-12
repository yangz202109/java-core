package com.study.nio.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author yangz
 * @date 2022/8/30 - 9:23
 * 使用nio拷贝文件 transform方法
 */
public class FileChannel04 {
    public static void main(String[] args) throws IOException {
        //创建流
        FileInputStream inputStream = new FileInputStream("D:\\util\\a.png");
        FileOutputStream outputStream = new FileOutputStream("D:\\util\\cd\\b.png");

        //获取流对应的channel
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();


        /*
          transform进行拷贝
          参数:
          src - 源频道
          position - 传输开始的文件中的位置; 必须是非负的
          count - 要传输的最大字节数; 必须是非负的
         */
        outputStreamChannel.transferFrom(inputStreamChannel,0,outputStreamChannel.size());

        //关闭流
        inputStreamChannel.close();//可选
        outputStreamChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
