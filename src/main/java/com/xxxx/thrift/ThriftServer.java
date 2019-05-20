package com.xxxx.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.generated.PersonService;

public class ThriftServer {

    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);   // socket
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());    // 协议
        arg.transportFactory(new TFramedTransport.Factory());   // 传输
        arg.processorFactory(new TProcessorFactory(processor)); // 处理器

        TServer server = new THsHaServer(arg);

        System.out.println("Thrift Server Started! ");

        server.serve();
    }
}
