package com.atang.rabbitmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqProducerApp extends SpringBootServletInitializer {
    /**
     * 负责启动引导应用程序
     *
     * @param args 入参
     */
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApp.class, args);
    }

}
