package com.xxxx.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-25 16:27
 */
public class OldIOClient {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 8899);

        String fileName = "D://gradle-4.0-all.zip";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送总字节数: " + total + ", 耗时: " + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }

    /**
     * 发送总字节数: 90002272, 耗时: 2245
     */
}
