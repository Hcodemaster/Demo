import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class SimpleHelloClient {
    public static final String SERVER_IP = "localhost";
    public static final  int SERVER_PORT = 8080;
    public static final int TIMEOUT = 30000;
    public static void main(String[] args) throws TException {
        SimpleHelloClient client = new SimpleHelloClient();
        client.startClient("huang");
    }
    public void startClient(String userName) throws TException {
        TTransport transport = null;
        //transport = new TSocket(SERVER_IP,SERVER_PORT,TIMEOUT);
        transport = new TFastFramedTransport(new TSocket(SERVER_IP,SERVER_PORT,TIMEOUT));
        TProtocol protocol = new TBinaryProtocol(transport);
        HelloWorldService.Client client = new HelloWorldService.Client(protocol);
        transport.open();
        String result = client.sayHello(userName);
        System.out.println("Result: " + result);
        transport.close();
    }
}
