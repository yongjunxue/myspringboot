package com.ceshi.lamda;

import java.util.Arrays;
import java.util.List;


public class Test {
	public void print(String name,int age){
		System.out.println(name+"--"+age);
	}
	
	public void send(String msg){
		System.out.println(msg);
	}
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("abc");
			System.out.println("efg");
		}).start();
		
		List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
	}
}
