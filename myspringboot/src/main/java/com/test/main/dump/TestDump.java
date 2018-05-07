package com.test.main.dump;

import java.util.ArrayList;
import java.util.List;

public class TestDump {
	
	public static void main(String[] args) {
		List<byte[]> li=new ArrayList<>();
		try{
			for(int i=0; i<100 ;i++){
				byte[] b=new byte[1024*1024];
				li.add(b);
			}
		}catch(Exception e){
			System.out.println(li.size());
		}
	}
}
