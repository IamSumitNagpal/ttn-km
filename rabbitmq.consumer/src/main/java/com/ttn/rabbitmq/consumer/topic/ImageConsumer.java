package com.ttn.rabbitmq.consumer.topic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttn.rabbitmq.consumer.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class ImageConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(ImageConsumer.class);

    @RabbitListener(queues = {"q.picture.vector","q.picture.image","q.picture.filter","q.picture.log"})
    public void listenImages(Message message) throws JsonProcessingException {
        Picture picture = objectMapper.readValue(new String(message.getBody()), Picture.class);
        logger.info("Routing key {} -> Picture {} ", message.getMessageProperties().getReceivedRoutingKey(), picture);
    }
}
