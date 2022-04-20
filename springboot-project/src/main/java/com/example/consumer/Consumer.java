package com.example.consumer;

import com.example.model.ListenerMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
//mesajları alacak class

    //.properties ->message.rabbitmq.queuename
    @RabbitListener(queues = "message.rabbitmq.queue.name") //bir message geldiğinde burası tetiklenecek
    public void handleMessage(ListenerMessage message){
        System.out.println(message.toString());
    }

}
