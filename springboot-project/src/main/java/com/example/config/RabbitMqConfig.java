package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    @Value ("${message.rabbit.queue.name}")
    private String queueName;
    @Value ("${message.rabbit.routing.name}")
    private String routingName;
    @Value ("${message.rabbit.exchange.name}")
    private String exchangeName;

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    Binding binding(final Queue queue, final DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }


}
