package com.test.pojo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectListener {
//	@RabbitHandler
	@RabbitListener(queues = "direct.d1")
    public void getD1(String hello) {
        System.out.println("getD1  : " + hello);
    }
	
//	@RabbitHandler
	@RabbitListener(queues = "direct.d2")
    public void getD2(String myTest) {
        System.out.println("getD2  : " + myTest);
    }
	
//	@RabbitListener(queues = "direct.english")//再direct模式下，如果两个监听者监听同一个队列，那么只有一个能收到消息
//    public void getMyTest1(String myTest) {
//        System.out.println("getMyTest1  : " + myTest);
//    }
}
