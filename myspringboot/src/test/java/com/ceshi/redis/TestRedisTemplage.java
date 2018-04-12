package com.ceshi.redis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.Start;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Start.class)
public class TestRedisTemplage {
	@Autowired
	RedisTemplate<String,String> template;
	
//	@Test
	public void set(){
		template.opsForValue().set("mykey", "abc");
		
		template.opsForList().leftPush("mylist", "1");
		template.opsForList().leftPush("mylist", "2");
		template.opsForList().leftPush("mylist", "3");
		
		template.opsForHash().put("map", "entry1", "map1");
		template.opsForHash().put("map", "entry2", "map2");
		template.opsForHash().put("map", "entry3", "map3");
		template.opsForHash().put("map", "entry2", "map4");
		
		template.opsForCluster();
		
	}
	@Test
	public void get(){
//		String o=template.opsForValue().get("mykey");
//		System.out.println(o);
//		
////		String mylist=template.opsForList().rightPop("mylist");
////		System.out.println(mylist);
//		
//		
//		Long size=template.opsForList().size("mylist");
//		List<String> list=template.opsForList().range("mylist", 0, -1);
//		list.forEach(e -> System.out.println(e));
//		System.out.println(list.toString());
//		System.out.println(template.opsForList().range("mylist", size-3, size-1));
//		
//		System.out.println(template.opsForHash().size("map"));
		
	}
}
