package com.ceshi.thread;

public class TestXingNeng {
	int a=0;
	int b=0;
	String str;
	public static void main(String[] args) throws InterruptedException {
		TestXingNeng t=new TestXingNeng();
		long count=10000;
		for(int j=1;j<=6;j++){
			Long start=System.currentTimeMillis();
			for(int i=1;i<=count;i++){
				t.test1();
			}
			System.out.print(System.currentTimeMillis()-start+"-----");
			start=System.currentTimeMillis();
			for(int i=1;i<=count;i++){
				t.test2();
			}
			System.out.println(System.currentTimeMillis()-start);
			
			count*=10;
		}
		
		
	}
	
	public void test1(){
		synchronized (TestXingNeng.class) {
			a++;
		}
	}
	public void test2(){
		b++;
	}
}
