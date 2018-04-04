package com.test.pojo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author xueyongjun
 *
 */
@Component
public class TopicListener1 {
	
	@RabbitListener(queues = "topic.t1")
    public void getT1(String myTest) {
        System.out.println("getT1  : " + myTest);
    }
	
	@RabbitListener(queues = "topic.t3")
    public void getT3(String myTest) {
        System.out.println("getT3  : " + myTest);
    }
}
