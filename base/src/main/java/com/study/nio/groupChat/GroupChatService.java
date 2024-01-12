package com.study.nio.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author yangz
 * @date 2022/9/16 - 14:54
 * 服务端：启动并监听8888,接送客户端消息 并实现转发[处理上线和离线]
 */
public class GroupChatService {
    //定义属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final Integer PORT = 8888;

    //初始化方法
    public GroupChatService() {
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将channel 注册 selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            System.out.println("初始化异常!!!");
        }
    }

    //监听方法
    public void listen() {
        try {
            //循环处理
            while (true) {
                //返回key的数量
                int count = selector.select(2000);

                if (count > 0) { //有事件处理
                    //遍历得到的selectorKey (有事件发生事件)集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        //取出key
                        SelectionKey key = iterator.next();

                        //监听到accept
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = listenChannel.accept();
                            socketChannel.configureBlocking(false);
                            //将socketChannel注册到 selector
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            //设置socketChannel 为非阻塞
                            socketChannel.configureBlocking(false);
                            //提示
                            System.out.println(socketChannel.getRemoteAddress() + "上线");
                        }
                        if (key.isReadable()) { //通道触发可读事件
                            readMsg(key);
                        }
                        //将处理完了的key从集合中删除 ,防止重复处理
                        iterator.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读取方法
    public void readMsg(SelectionKey key) {
        //获取key对应的channel
        SocketChannel channel = null;

        try {
            channel = (SocketChannel) key.channel();
            //创建缓存区保存读取数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //将channel中的数据读到buffer中
            int count = channel.read(byteBuffer);

            if (count > 0) {
                //将缓冲区的数据转成字符串并输出
                String msg = new String(byteBuffer.array());
                System.out.println("服务器收到消息 : " + msg);

                //将该消息转发给其他
                sendMsgToOtherClient(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + "离线了");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //转发消息给其他客户(通道)
    public void sendMsgToOtherClient(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中....");

        //遍历注册到 selector 中的所有channel ,并排除自己
        for (SelectionKey key : selector.selectedKeys()) {
            //取出key对应的channel
            SocketChannel targetChannel = (SocketChannel) key.channel();

            //排除self
            if (targetChannel != null && targetChannel != self) {
                //根据消息包装到缓冲区并返回
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer中的数据写入channel
                targetChannel.write(byteBuffer);
            }
        }
    }

    public static void main(String[] args) {
        GroupChatService chatService = new GroupChatService();
        chatService.listen();
    }
}
