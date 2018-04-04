package com.test.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig2 {
	@Bean
    public Queue getT2() {
        return new Queue("topic.t2");
    }
	
	@Bean
    Binding bindingT21() {
        return BindingBuilder.bind(getT2()).to(TopicExchangeConfig.getTopicExchange()).with("topic.t2");//*表示一个词,#表示零个或多个词
    }
	
	@Bean
    Binding bindingT22(@Qualifier("topicExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(getT2()).to(topicExchange).with("topic.t2");//*表示一个词,#表示零个或多个词
    }
	
	
}
