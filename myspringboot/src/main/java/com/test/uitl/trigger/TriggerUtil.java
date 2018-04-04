package com.test.uitl.trigger;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class TriggerUtil {
	
	private static TimeUnit default_time_Unit=TimeUnit.SECONDS;
	
	private static SchedulerFactoryBean schedulerFactoryBean;
	private static MethodInvokingJobDetailFactoryBean MethodInvokingJobDetailFactoryBean;
//	private static CronTriggerFactoryBean CronTriggerFactoryBean;
	
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
	
	public static void addTask(Object task,String targetMethod,int jiange){
		MethodInvokingJobDetailFactoryBean method=new MethodInvokingJobDetailFactoryBean();
		method.setTargetObject(task);
		MethodInvokingJobDetailFactoryBean MethodInvokingJobDetailFactoryBean;
	}

	public TimeUnit getTimeUnit() {
		return default_time_Unit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.default_time_Unit = timeUnit;
	}
	
	
}
