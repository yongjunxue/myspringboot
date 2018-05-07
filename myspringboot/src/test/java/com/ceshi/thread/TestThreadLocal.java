package com.ceshi.thread;

public class TestThreadLocal {
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			ThreadLocal<String> s=new ThreadLocal<String>();
			System.out.println(s.hashCode());
		}
	}
}
