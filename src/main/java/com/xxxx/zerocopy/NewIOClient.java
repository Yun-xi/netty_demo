package com.xxxx.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-25 16:37
 */
public class NewIOClient {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String fileName = "D://gradle-4.0-all.zip";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();

        /**
         * 将fileChannel对应的文件写入到目标socketChannel当中，
         * 将position开始到count的位置的数据写入到socketChannel中
         *
         * 从文件系统的缓存中直接将字节写入到目标通到当中，而不会去拷贝。
         */
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送总字节数: " + transferCount + ", 耗时: " + (System.currentTimeMillis() - startTime));

        fileChannel.close();
    }

    /**
     * 发送总字节数: 8388608, 耗时: 197
     */
}
