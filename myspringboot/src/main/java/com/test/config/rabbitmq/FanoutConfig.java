package com.test.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
	@Bean
    public Queue getF1() {
        return new Queue("fanout.f1");
    }
	
	@Bean
    public Queue getF2() {
        return new Queue("fanout.f2");
    }
	
	@Bean(name="fanoutExchange")
	public FanoutExchange getFanoutExchange() {
	    return new FanoutExchange("fanoutExchange");
	}
	
	@Bean
    Binding bindingF1() {
        return BindingBuilder.bind(getF1()).to(getFanoutExchange());
    }
	
	@Bean
    Binding bindingF2() {
        return BindingBuilder.bind(getF2()).to(getFanoutExchange());
    }
}
