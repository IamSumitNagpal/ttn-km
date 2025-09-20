package com.ttn.rabbitmq.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//@Service
public class RabbitMqFixedRateConsumer {


    @RabbitListener(queues = "fixed-rate", concurrency = "3-7")
    public void consumeMessage (String message) throws InterruptedException {
        System.out.println("Received : "+ ThreadLocal.class.getName()+ " " + message);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2));
    }
}
