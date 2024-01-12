package com.study.nio.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author yangz
 * @date 2022/9/17 - 10:54
 * 客户端: 连接服务端,发送消息,接送服务端的消息
 */
public class GroupChatClient {
    //定义属性
    private final String HOST = "127.0.0.1"; //服务器的ip
    private final Integer PORT = 8888;       //服务器的端口
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    //初始化
    public GroupChatClient() {
        try {
            selector = Selector.open();
            //连接服务端
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            //设置非阻塞模式
            socketChannel.configureBlocking(false);
            //将channel 注册 selector
            socketChannel.register(selector, SelectionKey.OP_READ);
            //获取username
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + "is ok....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务端发送消息
    public void sendMsgToService(String msg) throws IOException {
        //将消息放入buffer中
        msg = username + "=> " + msg;
        ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
        //将buffer中的数据写入channel
        socketChannel.write(byteBuffer);
    }

    //读取从服务端回复的消息
    public void readMsgToService(){
        try {
            int readChannel = selector.select();
            if (readChannel > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    //获取key
                    SelectionKey key = iterator.next();

                    if (key.isReadable()){
                        SocketChannel channel =(SocketChannel)key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        channel.read(byteBuffer);
                        System.out.println(Arrays.toString(byteBuffer.array()));
                    }
                    //移除处理后的key
                    iterator.remove();
                }
            }else {
                System.out.println("没有可用的通道...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        GroupChatClient chatClient = new GroupChatClient();

    }

}
