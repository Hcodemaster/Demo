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