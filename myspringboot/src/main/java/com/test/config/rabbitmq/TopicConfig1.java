package com.test.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig1 {
	@Bean
    public Queue getT1() {
        return new Queue("topic.t1");
    }
	
	@Bean
    public Queue getT3() {
        return new Queue("topic.t3");
    }
	
	@Bean
    Binding bindingT1() {
        return BindingBuilder.bind(getT1()).to(TopicExchangeConfig.getTopicExchange()).with("topic.t1");//*表示一个词,#表示零个或多个词
    }
	
	@Bean
    Binding bindingT3() {
        return BindingBuilder.bind(getT3()).to(TopicExchangeConfig.getTopicExchange()).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}
