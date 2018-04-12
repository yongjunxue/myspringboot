package com.test.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.test.uitl.redis.msg.MySub;
import com.test.uitl.redis.msg.MySub2;

@Configuration
public class MyRedisMsgListenerConfig {
	@Autowired
	JedisConnectionFactory config;
	@Autowired
	MySub mySub;
	@Autowired
	MySub2 mySub2;
	@Bean(name = "redisMessageListenerContainer")
	@Qualifier("redisMessageListenerContainer")
	public RedisMessageListenerContainer  getJedisConnectionFactory() {
//		MessageListenerAdapter a=new MessageListenerAdapter(new MySub(),"onMessage");
		RedisMessageListenerContainer r=new RedisMessageListenerContainer ();
		r.setConnectionFactory(config);
		
		//-------------具体的这部分可以可以专门配置到一个service中，用来添加监听--------------------
		r.addMessageListener(new MessageListenerAdapter(mySub,"onMessage"), new ChannelTopic("redis_publish")); 
		r.addMessageListener(new MessageListenerAdapter(new MySub(),"onMessage"), new ChannelTopic("redis_publish")); 
		r.addMessageListener(new MessageListenerAdapter(mySub2,"onMessage"), new ChannelTopic("redis_publish"));   //收不到---------
		r.addMessageListener(new MessageListenerAdapter(mySub2,"print"), new ChannelTopic("redis_publish")); //收不到---------
		//---------------------------------
		
		
//		r.addMessageListener(a, new ChannelTopic("redis_publish"));
		return r;
	}
}
