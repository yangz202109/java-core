package com.study.nio.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author yangz
 * @date 2022/9/16 - 9:32
 */
public class test {
    public static void main(String[] args) throws IOException {
        // 使用直接缓冲区完成文件的复制(内存映射文件)
        /*
         * 使用 open 方法来获取通道
         * 需要两个参数
         * 参数1：Path 是 JDK1.7 以后给我们提供的一个类，代表文件路径
         * 参数2：Option  就是针对这个文件想要做什么样的操作
         *      --StandardOpenOption.READ ：读模式
         *      --StandardOpenOption.WRITE ：写模式
         *      --StandardOpenOption.CREATE ：如果文件不存在就创建，存在就覆盖
         */
        FileChannel inChannel = FileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("c.txt"), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE);

        /*
         * 内存映射文件
         * 这种方式缓冲区是直接建立在物理内存之上的
         * 所以我们就不需要通道了
         */
        MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMapped.limit()];
        inMapped.get(dst);  // 把数据读取到 dst 这个字节数组中去
        outMapped.put(dst); // 把字节数组中的数据写出去

        inChannel.close();
        outChannel.close();
    }
}
