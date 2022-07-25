package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThriftClientConfigure {
    @Value("${server.thrift.host}")
    private String host;
    @Value("${server.thrift.port}")
    private int port;
    @Bean(initMethod = "init")
    public ThriftClient Tclient()
    {
        ThriftClient client = new ThriftClient();
        System.out.println("配置中读取host=" + host);
        client.setHost(host);
        client.setPort(port);
        return client;
    }
}
