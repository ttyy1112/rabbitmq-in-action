package com.atang.rabbitmq.consumer.listener;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "test_queue")
@Component
public class TestListener {
    private final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @RabbitHandler
    public void logMessage(Message message) {
        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        logger.info("receiving body {}.", body);
    }

    @RabbitHandler
    public void logMessage(String message) {
        logger.info("receiving body {}.", message);
    }
}
