package com.ceshi.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestArray {
	
	static class User {
		String name;
		int age;
		public User(){
			
		}
		public User(int age){
			this.age=age;
		}
	}
	public static void main(String[] args) {
		User [] ar=new User[5];
		User u=new User();
		u.name="zs";
		ar[0]=u;
		User [] ar2=Arrays.copyOf(ar, 6);
		ar2[0].name="ls";
		System.out.println(ar[0].name);
		System.out.println(ar2[0].name);
		
		Map<Integer,String> m=new HashMap();
		User aa;
		for(int j=1;j<=1000;j++){
			for(int i=1;i<=1000000;i++){
				aa=new User(1);
				m.put(aa.age, "");
				aa=null;
			}
		}
		System.out.println(m);
	}
}
