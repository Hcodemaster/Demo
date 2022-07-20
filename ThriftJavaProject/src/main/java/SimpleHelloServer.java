import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TServerSocket;

public class SimpleHelloServer {
    public static final int SERVER_POPRT = 8080;
    public static  void main(String[] args) throws Exception {
        SimpleHelloServer simpleHelloServer = new SimpleHelloServer();
        simpleHelloServer.startServer();
    }
    public void startServer() throws Exception
    {
        TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
        //TServerSocket serverSocket = new TServerSocket(SERVER_POPRT);
        //TSimpleServer.Args tArgs = new TSimpleServer.Args(serverSocket);
        //TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverSocket);
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(SERVER_POPRT);
        TNonblockingServer.Args tArgs = new TNonblockingServer.Args(serverSocket);
        tArgs.transportFactory(new TFastFramedTransport.Factory());
        tArgs.processor(tProcessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        //TServer server = new TSimpleServer(tArgs);
        TServer server = new TNonblockingServer(tArgs);
        server.serve();
    }
}
