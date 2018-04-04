package com.test.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author xueyongjun
 *
 */
@Configuration
public class MyRedisTemplateConfig {
	
	@Autowired
	JedisConnectionFactory config;
	
	@Bean(name = "redisTemplate")
	@Qualifier("redisTemplate")
	public <T> RedisTemplate<T,T> getRedisTemplate() {
		RedisTemplate<T,T>  template=new RedisTemplate<T,T> ();
		template.setConnectionFactory(config);
		return template;
	}
}
