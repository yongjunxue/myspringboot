package com.test.pojo.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * --------------MyListener不能用-------------------不要这么做
 * @author xueyongjun
 *
 */
@Component
@Deprecated
public class MyListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		System.out.println("MyListener:"+new String(message.getBody()));
	}

}
