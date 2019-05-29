package com.xxxx.nio;

import java.nio.ByteBuffer;

/**
 * 只读buffer，我们可以随时将一个普通Buffer调用asReadOnlyBuffer方法返回一个只读Buffer
 * 但不能将一个只读Buffer转换为读写Buffer
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-29 16:59
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte)i);
        }

        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readonlyBuffer.getClass());
    }
}
