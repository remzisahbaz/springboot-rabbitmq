package com.example;

import com.example.model.ListenerMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SpringbootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}


	ListenerMessage listenerMessage= new ListenerMessage();
	listenerMessage.setId(UUID.randomUUID().toString());
}
