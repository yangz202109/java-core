package com.study.nio.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yangz
 * @date 2022/8/25 - 17:19
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        //1.使用线程池管理线程
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try (ServerSocket socket = new ServerSocket(9999)) {


            while (true) {
                System.out.println("线程 Id = " + Thread.currentThread().getId() + " 名称 = " + Thread.currentThread().getName());

                System.out.println("等待连接.....");

                final Socket accept = socket.accept();
                System.out.println("连接到一个客服端");

                pool.execute(() -> handler(accept));
            }
        }
    }

    public static void handler(Socket socket) {
        byte[] bytes = new byte[1024];

        try {
            System.out.println("通信的线程是 id = " + Thread.currentThread().getId() + "名称 = " + Thread.currentThread().getName());
            //从socket中获取流
            InputStream inputStream = socket.getInputStream();
            //循环读取流中的数据
            while (true) {
                System.out.println("读取的线程是 id = " + Thread.currentThread().getId() + "名称 = " + Thread.currentThread().getName());
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭连接");
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
