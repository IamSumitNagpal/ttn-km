package com.ttn.rabbitmq.producer.fanout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttn.rabbitmq.producer.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class HRProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    public void sendMessage(Employee employee) throws JsonProcessingException {
        rabbitTemplate.convertAndSend("x.hr", "" , objectMapper.writeValueAsString(employee));
    }
}
