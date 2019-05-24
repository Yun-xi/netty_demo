package com.xxxx.grpc;

import com.xxxx.proto.MyRequest;
import com.xxxx.proto.MyResponse;
import com.xxxx.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-24 17:00
 */
public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();

        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

        MyResponse myResponse = blockingStub.getRealNameByUserName(MyRequest.newBuilder().setUsername("zhangsan").build());

        System.out.println(myResponse.getRealname());
    }
}
