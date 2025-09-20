package com.ttn.rabbitmq.consumer.fanout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttn.rabbitmq.consumer.entity.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ITConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(ITConsumer.class);

    @RabbitListener(queues = "x.hr.it")
    public void listenIT(String message) throws JsonProcessingException {
        Employee employee = objectMapper.readValue(message, Employee.class);
        logger.info("IT -> Joinee Employee {} ", employee);
    }
}
