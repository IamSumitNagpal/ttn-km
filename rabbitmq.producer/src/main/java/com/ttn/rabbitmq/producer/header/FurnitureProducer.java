package com.ttn.rabbitmq.producer.header;

import com.ttn.rabbitmq.producer.entity.Furniture;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FurnitureProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public void sendMessage(Furniture furniture) throws JsonProcessingException {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setHeader("color", furniture.getColor());
		messageProperties.setHeader("material", furniture.getMaterial());
		String furnitureJson = objectMapper.writeValueAsString(furniture);
		Message message = new Message(furnitureJson.getBytes(), messageProperties);
		rabbitTemplate.send("x.promotion", "", message);
	}

}
