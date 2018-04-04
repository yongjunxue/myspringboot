package com.test.config.rabbitmq;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class TopicExchangeConfig {
	
	static TopicExchange topicExchange;
	@Bean(name="topicExchange")
	public static TopicExchange getTopicExchange() {
		if(topicExchange==null){
			topicExchange=new TopicExchange("topicExchange");
		}
	    return topicExchange;
	}
}
