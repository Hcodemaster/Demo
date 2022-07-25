import org.apache.thrift.TException;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

import java.io.IOException;

public class AsyncHelloClient {
    public static final String SERVER_IP = "localhost";
    public static final  int SERVER_PORT = 8080;
    public static final int TIMEOUT = 30000;
    public static int finish = 0;
    public static void main(String[] args) throws TException, IOException, InterruptedException {
        AsyncHelloClient client = new AsyncHelloClient();
        client.startClient("huang");
    }

    private void startClient(String userName) throws IOException, InterruptedException, TException {
        TAsyncClientManager clientManager = new TAsyncClientManager();
        TNonblockingTransport transport = new TNonblockingSocket(SERVER_IP,SERVER_PORT,TIMEOUT);
        TProtocolFactory tProtocolFactory = new TBinaryProtocol.Factory();
        HelloWorldService.AsyncClient client = new HelloWorldService.AsyncClient(tProtocolFactory,clientManager,transport);
        client.sayHello(userName,new AsyncHandler());
        Thread.sleep(500);
        System.out.println("do other work");
        while (finish == 0)
        {
        }
        transport.close();
    }
    class AsyncHandler implements AsyncMethodCallback<String>
    {

        @Override
        public void onComplete(String s) {
            System.out.println("get results: " + s);
            finish = 1;
        }

        @Override
        public void onError(Exception e) {
            System.out.println("failure: "+ e.getMessage());
        }
    }
}
