package com.ttn.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RabbitMqFixedRateProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    int i = 0;
    @Scheduled(fixedRate = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void sendMessage(){
        i++;
        rabbitTemplate.convertAndSend("fixed-rate", "Message : "+ i);
    }
}
