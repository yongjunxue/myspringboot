package com.test.config.redis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class MyJedisConnectionFactoryConfig {
	
	@Value("${redis.port}")
	private int port;  
	@Value("${redis.hostName}")
	private String hostName;
	
	@Bean(name = "redisStandaloneConfiguration")
	@Qualifier("redisStandaloneConfiguration")
	public RedisStandaloneConfiguration getRedisStandaloneConfiguration() {
		return new RedisStandaloneConfiguration(hostName,port);
	}
	
	@Bean(name = "jedisConnectionFactory")
	@Qualifier("jedisConnectionFactory")
	public JedisConnectionFactory getJedisConnectionFactory(RedisStandaloneConfiguration config) {
		return new JedisConnectionFactory(config);
	}
}
