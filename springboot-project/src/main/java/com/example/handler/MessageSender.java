package com.example.handler;

import com.example.model.ListenerMessage;
import com.example.producer.MessageProducer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class MessageSender {
    private final MessageProducer producer;

    public MessageSender(MessageProducer producer) {
        this.producer = producer;
    }

    @PostConstruct
    public void init() {
        getThread();

    }

    public void getThread() {

        ListenerMessage listenerMessage = new ListenerMessage();
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        listenerMessage.setId(UUID.randomUUID().toString());
        listenerMessage.setCreateDate(new Date());
        listenerMessage.setMessageText("Remzi ŞAHBAZ, RabbitMq ile mesaj gönderiyor.");
        listenerMessage.setSeen(Boolean.FALSE);
        executor.scheduleAtFixedRate(() -> {

            try {
                producer.senToQueue(listenerMessage);

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }

        }, 0, 500, TimeUnit.MILLISECONDS);


    }


}
