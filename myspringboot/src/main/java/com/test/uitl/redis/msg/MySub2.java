package com.test.uitl.redis.msg;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

/**
 * 不实现MessageListener收不到消息。具体请参考MySub
 * @author xueyongjun
 *
 */

@Service
public class MySub2{
	private static final Logger logger = Logger.getLogger(MySub2.class.getName());
//	@Autowired
//	RedisMessageListenerContainer lis;
	@Autowired
	RedisTemplate<String,String> template;
	public MySub2(){
//		lis.addMessageListener(new MessageListenerAdapter(this,"onMessage"), new ChannelTopic("redis_publish"));
	}
	public void onMessage(String msg){
		System.out.println("MySub2:"+msg);
	}
	public void print(){
		System.out.println("MySub2.print:");
	}
	
}
