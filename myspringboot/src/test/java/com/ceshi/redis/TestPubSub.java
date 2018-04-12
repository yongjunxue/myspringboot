package com.ceshi.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.Start;
import com.test.uitl.redis.msg.MyPub;

/**
 * 用redis没有实现发布订阅模式!!!!!!!!
 * @author xueyongjun
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Start.class)
public class TestPubSub {
	@Autowired
	MyPub pub;
	
	
	@Test
	public void send(){
		
		pub.send("redis_publish","发消息了");
		
	}
}
