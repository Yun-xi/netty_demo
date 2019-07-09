package com.xxxx.netty.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Hello World
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-09 13:53
 */
public class TestServer {

    public static void main(String[] args) throws InterruptedException {
            // 事件循环组
            EventLoopGroup bossGroup = new NioEventLoopGroup();         // 从客户端接收连接，会把连接发送给workerGroup
            EventLoopGroup workerGroup = new NioEventLoopGroup();       // 业务处理，返回给客户端

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();    // 服务端启动
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.WARN))
                    .childHandler(new TestServerinitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
