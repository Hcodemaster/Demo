package com.example.client;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClient {
    private String host;
    private Integer port;

    private TTransport tTransport;
    private TProtocol tProtocol;
    private StudentService.Client client;
    private void init()
    {
        System.out.println("host=" + host);
        System.out.println("port= " + port);
        tTransport = new TFramedTransport(new TSocket(host,port),600);
        tProtocol = new TBinaryProtocol(tTransport);
        client = new StudentService.Client(tProtocol);
    }

    public StudentService.Client getService()
    {
        return client;
    }

    public void open() throws TTransportException {
        tTransport.open();
    }

    public void close()
    {
        tTransport.close();
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
