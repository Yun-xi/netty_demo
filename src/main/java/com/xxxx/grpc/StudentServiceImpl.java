package com.xxxx.grpc;

import com.xxxx.proto.MyRequest;
import com.xxxx.proto.MyResponse;
import com.xxxx.proto.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-24 14:38
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUserName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端信息: " + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }
}
