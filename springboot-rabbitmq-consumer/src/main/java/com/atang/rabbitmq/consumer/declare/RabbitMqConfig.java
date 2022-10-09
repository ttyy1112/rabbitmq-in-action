package com.atang.rabbitmq.consumer.declare;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public static final String TEST_TOPIC_EXCHANGE = "test_topic_exchange";
    public static final String TEST_QUEUE = "test_queue";

    @Bean("testExchange")
    public Exchange testExchange() {
        return ExchangeBuilder.topicExchange(TEST_TOPIC_EXCHANGE).durable(true).build();
    }

    @Bean("testQueue")
    public Queue testQueue() {
        return QueueBuilder.durable(TEST_QUEUE).build();
    }

    @Bean
    public Binding getBinding(@Qualifier("testQueue") Queue queue, @Qualifier("testExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("test.#").noargs();
    }
}
