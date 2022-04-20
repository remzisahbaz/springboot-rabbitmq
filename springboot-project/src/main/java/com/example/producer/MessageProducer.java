package com.example.producer;

import com.example.model.ListenerMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Value ("${message.rabbitmq.routing.name}")
    private String routingName;

    @Value("${message.rabbitmq.exchange.name}")
    private String exchangeName;

    private final RabbitTemplate rabbitTemplate;
    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void senToQueue(ListenerMessage message) {
        //üretilen mesaj istenilen formata çevrilip gönderiliyor.
        //hangi queueName gideceğinide belirtiyoruz
        System.out.println("Message Sent Id:" + message.getId());
     //   System.out.println(message + "exchangeName: " +exchangeName+" routingName: "+routingName);
        rabbitTemplate.convertAndSend(exchangeName,routingName, message);


    }


}
