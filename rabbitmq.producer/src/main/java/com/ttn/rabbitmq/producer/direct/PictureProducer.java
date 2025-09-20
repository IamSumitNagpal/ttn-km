package com.ttn.rabbitmq.producer.direct;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttn.rabbitmq.producer.entity.Picture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class PictureProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendPicture(Picture picture) throws JsonProcessingException {
        String pic = objectMapper.writeValueAsString(picture);
        rabbitTemplate.convertAndSend("x.picture", picture.getType() ,pic);
    }
}
