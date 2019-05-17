package com.xxxx.netty.sixthexample;

import com.xxxx.netty.thirdexample.MyChatClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-17 16:07
 */
public class TestClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new TestClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();


        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
