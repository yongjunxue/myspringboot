package com.ceshi.elastic.repository;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.Start;
import com.test.pojo.elastic.User;
import com.test.repositoty.elastic.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Start.class)
public class UserRepositoryTest {
	
	 @Autowired  
	 private UserRepository userRepository;
	 
	 @Test
	 public void save(){
		 User u=new User();
		 u.setAge(50);
		 u.setMoney(5000);
		 u.setName("王志");
		 u.setPassword("12345");
//		 u.setTel("");
		 userRepository.save(u);
		 Iterable<User> ite=userRepository.findAll();
		 Iterator<User> it=ite.iterator();
		 while(it.hasNext()){
			 User user=it.next();
			 System.out.println(user);
		 }
	 }
	 
//	 @Test
//	 public void save(){
//		 User u=new User();
//		 u.setAge(50);
//		 u.setMoney(5000);
//		 u.setName("王志");
//		 u.setPassword("123");
////		 u.setTel("");
//		 userRepository.save(u);
//	 }
	 
}
