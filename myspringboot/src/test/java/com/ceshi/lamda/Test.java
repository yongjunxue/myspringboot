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
//		new Thread(()->{
//			System.out.println("abc");
//			System.out.println("efg");
//		}).start();
//		
//		List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
		
		TestBiBao t=new TestBiBao();
		Lambda la=t.getLambda();
		t=null;
		System.out.println(la.get("aaa"));
		System.out.println(t);
	}
	
	
	
}
class TestBiBao{
	public Lambda getLambda(){
		return new Lambda(){
			@Override
			public String get(String s) {
				return "msg:"+s;
			}
		};
	}
}
interface Lambda{
	public String get(String s);
}