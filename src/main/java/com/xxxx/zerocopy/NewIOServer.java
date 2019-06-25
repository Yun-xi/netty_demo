package com.xxxx.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-25 16:37
 */
public class NewIOServer {

    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        /*
            启用SO_REUSEADDR这个属性，
            当一个TCP连接关闭的时候，连接本身会保持一定时间的超时时间，此时这个socket处于超时的状态，如果一个服务端上面有一个超时状态的socket连接的话，其他的socket1就不能连接绑定到这个端口
            SO_REUSEADDR这个属性就是为了解决这个问题的，可以让其他的socket连接
         */
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);

            int readCount = 0;

            while (-1 != readCount) {
                try {
                    readCount = socketChannel.read(byteBuffer);

                }catch (Exception e) {

                }

                byteBuffer.rewind();
            }
        }
    }
}
