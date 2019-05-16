package com.xxxx.netty.sixthexample;

public class TestServer {

    public static void main(String[] args) {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                .setName("李四").build();
        System.out.println(person);
    }
}
