package com.example.consumer;

import com.example.model.ListenerMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
//mesajları alacak class

    //.properties ->message.rabbitmq.queuename
    @RabbitListener(queues = "chatlist-queue") //bir message geldiğinde burası tetiklenecek
    public void handleMessage(ListenerMessage message){
        System.out.println("*****************Message received :*********************************");
        System.out.println(message.toString());
    }

}
