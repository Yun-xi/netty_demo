package com.xxxx.netty.test;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-26 17:54
 */
public class Test {

    public static void main(String[] args) {
        int result = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(result);
    }
}
