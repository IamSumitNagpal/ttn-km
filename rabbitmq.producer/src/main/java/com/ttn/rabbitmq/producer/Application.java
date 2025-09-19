package com.ttn.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("welcome to rabbitmq session");
	}


	@Autowired
	private RabbitMqProducer rabbitMqProducer;

	@Override
	public void run(String... args) throws Exception {
		logger.info("About to send Message");
		rabbitMqProducer.sendMessage("realtime message");
		logger.info("Message Sent");
	}
}
