package com.ceshi.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.Start;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Start.class)
public class TestRabbit {
	@Autowired
    private AmqpTemplate amqpTemplate; //配置方式1，默认的配置
	
	@Autowired
    private RabbitTemplate rabbitTemplate; //配置方式2
	
//	@Test
	public void testFanout(){
		for(int i=1;i<=10;i++){
			rabbitTemplate.convertAndSend("fanoutExchange", "", "我是fanout"+i);
		}
	}
	
	@Test
	public void testTopic(){
		for(int i=1;i<=10;i++){
			rabbitTemplate.convertAndSend("topicExchange", "topic.t1", "我是topic.t1:"+i);
		}
	}
	
//	@Test
	public void send(){
//		amqpTemplate.convertAndSend("direct.english", "AmqpTemplate发送english");
//		amqpTemplate.convertAndSend("direct.math", "AmqpTemplate发送math");
//		amqpTemplate.convertAndSend("myTest", "AmqpTemplate发送myTest");
		
//		rabbitTemplate.convertAndSend("direct.english", "rabbitTemplate发送english");
//		rabbitTemplate.convertAndSend("direct.math", "rabbitTemplate发送math");
//		rabbitTemplate.convertAndSend("myTest", "rabbitTemplate发送myTest");
		
		
//		for(int i=1;i<=10;i++){
//			rabbitTemplate.convertAndSend("topicExchange2", "topic.english", "我是english"+i);
//		}

//		for(int i=1;i<=10;i++){
//			//-----------------------不知道为啥，topic.t2的队列绑定不到交换机？？？？？？？？？？？？？？？？？？？？
//			rabbitTemplate.convertAndSend("topicExchange2", "topic.", "我是t1"+i);
//		}
		
//		new Thread( new Runnable() {
//			public void run() {
//				for(int i=1;i<=10;i++){
////					//-----------------------不知道为啥，topic.t2的队列绑定不到交换机？？？？？？？？？？？？？？？？？？？？
//					rabbitTemplate.convertAndSend("topicExchange2", "topic.", "我是t1"+i);
//				}
//			}
//		}).start();
		
//		
//		ExecutorService es=Executors.newFixedThreadPool(5);
//		for(int i=1;i<=10;i++){
//			es.execute(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						Thread.currentThread().sleep(5000);
////					for(int i=1;i<=10;i++){
//						rabbitTemplate.convertAndSend("topicExchange2", "topic.english", "我是english"+Thread.currentThread().getId());
////					}
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}
		
		
		
		
	}
}
