package com.test.pojo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author xueyongjun
 *
 */
@Component
public class TopicListener2 {
	
	@RabbitListener(queues = "topic.t2")
    public void getT2(String myTest) {
        System.out.println("getT2  : " + myTest);
    }
}
