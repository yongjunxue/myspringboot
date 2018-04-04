package com.test.config.trigger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class TriggerConfig {
	@Bean(name = "schedulerFactoryBean")
	@Qualifier("schedulerFactoryBean")
	public SchedulerFactoryBean getSchedulerFactoryBean() {
		return new SchedulerFactoryBean();
	}
	
	@Bean(name = "methodInvokingJobDetailFactoryBean")
	@Qualifier("methodInvokingJobDetailFactoryBean")
	public MethodInvokingJobDetailFactoryBean getMethodInvokingJobDetailFactoryBean() {
		return new MethodInvokingJobDetailFactoryBean();
	}
	@Bean(name = "cronTriggerFactoryBean")
	@Qualifier("cronTriggerFactoryBean")
	public CronTriggerFactoryBean getCronTriggerFactoryBean() {
		return new CronTriggerFactoryBean();
	}
	
}
