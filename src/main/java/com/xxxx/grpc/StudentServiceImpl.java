package com.xxxx.grpc;

import com.xxxx.proto.*;
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

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收岛客户端信息: " + request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder()
                .setName("张三")
                .setAge(20)
                .setCity("北京")
                .build());
        responseObserver.onNext(StudentResponse.newBuilder()
                .setName("李四")
                .setAge(30)
                .setCity("天津")
                .build());
        responseObserver.onNext(StudentResponse.newBuilder()
                .setName("王五")
                .setAge(40)
                .setCity("南京")
                .build());
        responseObserver.onNext(StudentResponse.newBuilder()
                .setName("赵六")
                .setAge(50)
                .setCity("上海")
                .build());

        responseObserver.onCompleted();
    }
}
