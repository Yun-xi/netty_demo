package com.xxxx.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-10 14:53
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyByteToLongDecoder2());
        pipeline.addLast(new MyLongToByteEncoder());
        pipeline.addLast(new MyLongToStringDecoder());
        pipeline.addLast(new MyServerHandler());
    }
}
