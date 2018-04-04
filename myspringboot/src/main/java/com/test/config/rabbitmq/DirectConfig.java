package com.test.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {
	@Bean
    public Queue getD1() {
        return new Queue("direct.d1");
    }
	@Bean
    public Queue getD2() {
        return new Queue("direct.d2");
    }
	
}
