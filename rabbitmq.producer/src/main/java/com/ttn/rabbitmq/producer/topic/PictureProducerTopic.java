package com.ttn.rabbitmq.producer.topic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttn.rabbitmq.producer.entity.Picture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class PictureProducerTopic {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendPicture(Picture picture) throws JsonProcessingException {
        String stringBuilder =
                picture.getSource() +
                "." +
                (picture.getSize() > 4000 ? "large" : "small") +
                "." +
                picture.getType();
        String pic = objectMapper.writeValueAsString(picture);
        rabbitTemplate.convertAndSend("x.picture2", stringBuilder,pic);
    }
}
