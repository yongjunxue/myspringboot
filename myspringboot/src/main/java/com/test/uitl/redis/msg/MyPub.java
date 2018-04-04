package com.test.uitl.redis.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyPub {
	@Autowired
	RedisTemplate<String,String> template;
	
	public void send(String channel,String msg){
		template.convertAndSend(channel, msg);
	}
}
