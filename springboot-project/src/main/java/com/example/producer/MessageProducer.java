package com.example.producer;

import com.example.model.ListenerMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Value ("${message.rabbitmq.routing.name}")
    private String routingName;

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void senToQueue(ListenerMessage message) {
        //üretilen mesaj istenilen formata çevrilip gönderiliyor.
        //hangi queueName gideceğinide belirtiyoruz
        System.out.println("Mesagge Sent Id:"+message.getId());
        rabbitTemplate.convertAndSend(routingName, message);


    }


}
