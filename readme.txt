记录学习过程中的Demo项目
1、Thrift Demo
Thrift是一种包含序列化功能和支持服务通信的rpc框架，也是一种微服务框架。支持多种不同的编程语言使用


2、Thrift + SpringBoot 简单实战
分为两部分：ThriftClient 在SpringBoot的框架中将Thrift客户端作为Service组件实现，并通过SpringMVC以Rest风格对外提供服务
           SpringBootThrift 在SpringBoot的框架中实现Thrift的服务端
Tips：在properties或yaml文件中配置的端口号与host信息建议通过@Value注解获取



3、SpringBoot + MyBatis
首先需要配置数据源，接着导入Mybatis的starter即可



4、SpringBoot + MyBatisPlus
使用方法与3一致
更新了MyBatisPlus 条件查询Wrapper的使用
更新了MyBatisPlus 分页插件的使用
MyBatisPlus分页插件自定义查询结果分页的步骤如下：
    一、在Mapper接口中定义自定义查询的接口方法，方法中需要包含Page或者IPage对象
    二、在MyBatisPlus默认放置的Mapper.xml文件中进行相应地实现
Tips：方法中放置Page或者IPage对象后，引入的PaginationInnerInterceptor拦截器就可以拦截到该方法
并根据此方法查询结果按照传入的Page对象要求进行分页


5、SpringBoot + Redis
导入Redis的starter即可
通过已经由SpringBoot自动装配的StringRedisTemplate或RedisTemplate进行操纵访问
结合Interceptor进行用户访问统计计数


6、Java + Kafka 
首先在本地搭建Zookeeper与Kafka，然后导入Kafka-client的依赖


7、SpringBoot + Kafka
首先创建Producer与Consumer两个项目，并分别在pom文件中写入Kafka的依赖
依次在Producer与Consumer项目的配置文件中配置必要的配置信息，
两个项目中都必须需要配置的属性项包括key和value的序列化和反序列化器
在Consumer项目中额外需要配置gruoup-id属性项
发送消息至特定主题可以直接采用KafkaTemplate来操纵
消费消息则可以直接通过@ListenerXXXXX的注解来获取消息
同时可以在@ListenerXXXXX的注解中添加自定义的消息过滤器

Kafka支持集群部署，基本步骤如下：
    一、部署Zookeeper集群（每个机器安装Zookeeper并修改配置文件）
    二、每个机器安装Kafka，并修改其配置文件，最重要的一个属性为（broker-id）



8、SpringBoot + RabbitMQ
首先需要搭建RabbitMq环境，然后导入其Starter，并且同样是通过RabbitTemplate进行操纵发送消息
通过@xxxListener注解进行监听，在该注解中需要配置queue属性，用于从相应的队列中消费消息
并且，需要额外注入消息队列，各种类型的交换机的Bean，以及将队列按照规则进行绑定的binding等Bean
在目前的Demo中仅试验了默认模式、广播模式以及最常用的发布订阅模式(Topic)




