package com.test.uitl.redis.msg;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

/**
 * 
 * @author xueyongjun
 *
 */

@Service
public class MySub implements MessageListener{
	private static final Logger logger = Logger.getLogger(MySub.class.getName());
	public MySub(){
	}
	@Override
	public void onMessage(Message message, byte[] pattern) {
		
		byte[] body=message.getBody();
		byte[] channel=message.getChannel();
		System.out.println("消息体:"+new String(body));
		System.out.println("频道："+new String(channel));
		System.out.println(message.toString());
	}
	
}
