package com.study.nio.nio.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yangz
 * @date 2022/9/14 - 14:01
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel --> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到Selector对象
        Selector selector = Selector.open();

        //绑定端口8888 在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //将serverSocketChannel注册到 selector 关系 事件为OP_ACCEPT(连接)
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端来连接
        while (true){
            if (selector.select(1000) == 0){ //没有事件发生
                System.out.println("服务器等待1秒,无客户端连接");
              continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){

            }
        }
    }
}
