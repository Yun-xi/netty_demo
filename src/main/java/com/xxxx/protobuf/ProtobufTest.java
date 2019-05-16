package com.xxxx.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-16 16:18
 */
public class ProtobufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三")
                .setAge(20)
                .setAddress("北京")
                .build();

        byte[] student2ByteArray = student.toByteArray();

        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student2);
    }
}
