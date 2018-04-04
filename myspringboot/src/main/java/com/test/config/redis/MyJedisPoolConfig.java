package com.test.config.redis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPoolConfig;
@Configuration
public class MyJedisPoolConfig {
	@Bean(name = "jedisPoolConfig")
	@Qualifier("jedisPoolConfig")
	public JedisPoolConfig getJedisPoolConfig() {
		return new JedisPoolConfig();
	}
}
