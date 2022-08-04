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

