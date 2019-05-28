package com.xxxx.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-28 15:28
 */
public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        // 翻转 上面的IntBuffer为写，下面的IntBuffer为读，读写切换
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
