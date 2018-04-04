package com.test.pojo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author xueyongjun
 *
 */
@Component
public class FanoutListener {
	
	@RabbitListener(queues = "fanout.f1")
    public void getF1(String myTest) {
        System.out.println("getF1 : " + myTest);
    }
	
	@RabbitListener(queues = "fanout.f2")    
    public void getF2(String hello) {
        System.out.println("getF2  : " + hello);
    }
}
