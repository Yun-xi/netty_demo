package com.xxxx.netty.handler2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-10 15:23
 */
public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        IntStream.range(0, 10).forEach(i -> {
            ByteBuf buffer = Unpooled.copiedBuffer("sent from client ", Charset.forName("utf-8"));
            ctx.writeAndFlush(buffer);
        });
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);

        String message = new String(buffer, Charset.forName("utf-8"));

        System.out.println("客户端接收到的消息内容:  " + message);
        System.out.println("客户端接收到的消息数量:  " + (++this.count));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
