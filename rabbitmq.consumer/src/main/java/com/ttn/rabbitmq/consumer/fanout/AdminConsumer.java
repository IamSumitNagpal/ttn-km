package com.ttn.rabbitmq.consumer.fanout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttn.rabbitmq.consumer.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class AdminConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(AdminConsumer.class);

    @RabbitListener(queues = "x.hr.admin")
    public void listenIT(String message) throws IOException {
        Employee employee = objectMapper.readValue(message, Employee.class);
        logger.info("Admin -> Received Employee {} ", employee);
        if(Objects.isNull(employee.getName())){
            throw new IOException("Name should not be null");
        }
        logger.info("Admin -> Joinee Employee {} ", employee);
    }
}
