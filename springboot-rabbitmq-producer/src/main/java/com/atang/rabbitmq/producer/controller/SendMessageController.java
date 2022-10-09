package com.atang.rabbitmq.producer.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
    public static final Logger logger = LoggerFactory.getLogger(SendMessageController.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sendMessage")
    public void sendMessage() {
        String context = "Current Date: " + new Date();
        logger.info("Sender : " + context);
        this.rabbitTemplate.convertAndSend("test_topic_exchange", "test.date", context);
    }

}