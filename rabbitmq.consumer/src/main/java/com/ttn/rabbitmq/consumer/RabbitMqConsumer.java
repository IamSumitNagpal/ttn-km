package com.ttn.rabbitmq.consumer;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitMqConsumer {
    @RabbitListener(queues = "first-queue", ackMode = "MANUAL")
    public void consumeMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) Long tag) throws IOException {
        System.out.println("Received : "+ message);
        channel.basicAck(tag, false);
    }
}
