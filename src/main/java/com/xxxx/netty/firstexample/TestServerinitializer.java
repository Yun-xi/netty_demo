package com.xxxx.netty.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 在channel在创建好之后，自动创建并执行里面的代码
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-09 14:12
 */
public class TestServerinitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("httpServerCodec", new HttpServerCodec()); // 对web的请求和响应编解码
        pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
    }
}
