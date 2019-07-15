package com.xxxx.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-10 15:00
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + ", " + msg);
        ctx.channel().writeAndFlush("from server: " + UUID.randomUUID());

         ctx.writeAndFlush("from server: " + UUID.randomUUID());
        /**
         * ctx.channel().writeAndFlush(Object msg)
         * ctx.writeAndFlush(Object msg)
         *
         * 这俩种方法的区别是:
         * ctx.channel().writeAndFlush(Object msg)是从ChannelPipeline的末尾开始往前流动
         * ctx.writeAndFlush(Object msg)是从ChannelPipeline的当前ChannelHandler往前流动
         */
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
