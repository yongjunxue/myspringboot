package com.ceshi.trigger;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.DirectSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;


public class TestTrigger {
	public static void main(String[] args) throws SchedulerException {
		DirectSchedulerFactory.getInstance().createVolatileScheduler(3);
		Scheduler s = DirectSchedulerFactory.getInstance().getScheduler();
		SimpleTriggerImpl st =new SimpleTriggerImpl();
		st.setRepeatInterval(1000);
		
		JobDetail j =JobBuilder.newJob().build();
		s.scheduleJob(st);
		
		s.clear();
		
		System.out.println(s.toString());
	}
}
