package com.angryzyh.service.impl.rabbitmq.direct.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

//@Configuration
public class RabbitMQDirectConfig {

    @Bean
    public Queue directQueue1() {
        return new Queue("direct_queue1");
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("direct_queue2");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding bindingDirect1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with("direct11");
    }

    @Bean
    public Binding bindingDirect2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with("direct22");
    }

}
