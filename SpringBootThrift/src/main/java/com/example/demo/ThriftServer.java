package com.example.demo;

import lombok.Data;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "server.thrift")
public class ThriftServer {
    private int port ;
    private int minThreadPool;
    private int maxThreadPool;

    @Autowired
    MyServerServiceImpl myServerService;
    public void start() throws TTransportException {
        StudentService.Processor<MyServerServiceImpl> processor = new StudentService.Processor<MyServerServiceImpl>(myServerService);
        TNonblockingServerSocket socket = new TNonblockingServerSocket(port);
        THsHaServer.Args args = new THsHaServer.Args(socket).minWorkerThreads(minThreadPool).minWorkerThreads(maxThreadPool);
        args.protocolFactory(new TBinaryProtocol.Factory());
        args.transportFactory(new TFramedTransport.Factory());
        args.processorFactory(new TProcessorFactory(processor));
        TServer server = new THsHaServer(args);
        System.out.println("开始启动Thrift服务端口号为：" + port);
        server.serve();
    }

}
