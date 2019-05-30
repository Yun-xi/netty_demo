package com.xxxx.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 在内存中直接修改文件数据，MappedByteBuffer将文件映射到内存中，
 * 修改完之后，操作系统会自动写入到文件中
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-30 13:53
 */
public class NioTest9 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest9.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte)'a');
        mappedByteBuffer.put(3, (byte)'b');

        randomAccessFile.close();
    }
}
