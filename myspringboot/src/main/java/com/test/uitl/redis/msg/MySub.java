package com.test.uitl.redis.msg;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 收不到消息，可能监听没有起作用吧？？
 * @author xueyongjun
 *
 */

@Service
public class MySub implements MessageListener{
	private static final Logger logger = Logger.getLogger(MySub.class.getName());
	@Autowired
	RedisTemplate<String,String> template;
	@Override
	public void onMessage(Message message, byte[] pattern) {
		byte[] body=message.getBody();
		byte[] channel=message.getChannel();
		System.out.println("消息体:"+body);
		System.out.println("频道："+channel);
		System.out.println(message.toString());
		System.out.println(template.getValueSerializer().deserialize(body));
		logger.info((String) template.getValueSerializer().deserialize(body));
	}
	
}
