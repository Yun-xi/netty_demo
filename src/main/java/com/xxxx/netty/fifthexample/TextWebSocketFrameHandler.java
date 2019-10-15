package com.xxxx.netty.fifthexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDate;

public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 用于记录和管理所有客户端的channel
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("收到消息: " + msg.text());

        clients.forEach(channel ->
            channel.writeAndFlush(new TextWebSocketFrame("服务器时间: " + LocalDate.now()))
        );
        // 这个方法和上面的for循环是一致的
//        clients.writeAndFlush(new TextWebSocketFrame("服务器时间: " + LocalDate.now()));
//        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间: " + LocalDate.now()));
    }

    /**
     * 当客户端连接服务端后（打开连接）
     * 获取客户端的channel，并且放到ChannelGroup中去进行处理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        clients.add(channel);
        System.out.println("handlerAdder: " + ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel
//        clients.remove(ctx.channel());
        System.out.println("handlerRemoved, 长id： " + ctx.channel().id().asLongText());
        System.out.println("handlerRemoved, 短id： " + ctx.channel().id().asShortText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生");
        ctx.close();
    }
}
