package com.example.demo.RabbitMqConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqconfig {
    @Bean(name = "queue_work")
    public Queue queueWork()
    {
        return new Queue("queue_work");
    }

    @Bean(name = "queue_fanout1")
    public Queue queue_fanout1()
    {
        return  new Queue("queue_fanout1");
    }

    @Bean(name = "queue_fanout2")
    public Queue queuefanout2()
    {
        return new Queue("queue_fanout2");
    }

    @Bean(name = "exchange_fanout")
    public FanoutExchange fanoutExchange()
    {
        return new FanoutExchange("exchange_fanout");
    }

    @Bean(name = "queue1_binding")
    public Binding bindingExchange1()
    {
        return BindingBuilder.bind(queue_fanout1()).to(fanoutExchange());
    }

    @Bean(name = "queue2_binding")
    public Binding bindingExchange2()
    {
        return BindingBuilder.bind(queuefanout2()).to(fanoutExchange());
    }

    @Bean(name = "queue_topic1")
    public Queue queue_topic1()
    {
        return new Queue("queue_topic1");
    }
    @Bean(name = "queue_topic2")
    public Queue queue_topic2()
    {
        return new Queue("queue_topic2");
    }
    @Bean(name = "topicExchange")
    public TopicExchange topicExchange()
    {
        return new TopicExchange("topicExchange");
    }

    @Bean(name = "Binding1")
    public Binding TopicBinding1()
    {
        return BindingBuilder.bind(queue_topic1()).to(topicExchange()).with("topic.#");
    }

    @Bean(name = "Binding2")
    public Binding TopicBinding2()
    {
        return BindingBuilder.bind(queue_topic2()).to(topicExchange()).with("topic.*");
    }
}
