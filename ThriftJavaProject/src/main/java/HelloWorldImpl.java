import org.apache.thrift.TException;

public class HelloWorldImpl implements HelloWorldService.Iface{

    @Override
    public String sayHello(String name) throws TException {
        // TODO Auto-generated method stub
        return "hello, " + name;
    }
    
}
