package com.xxxx.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-17 16:11
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                .setName("张三")
                .setAge(20)
                .setAddress("北京")
                .build();

        ctx.channel().writeAndFlush(person);
    }
}
