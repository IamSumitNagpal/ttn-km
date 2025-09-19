package com.ttn.rabbitmq.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer {


    @RabbitListener(queues = "first-queue")
    public void consumeMessage(String message){
        System.out.println("Received : "+ message);
    }
}
