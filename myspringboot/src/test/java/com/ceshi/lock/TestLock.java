package com.ceshi.lock;


public class TestLock {
	volatile int a=111;
	int b=222;
	
	private volatile TestLock testLock;
	
	private TestLock(){
		a=a+1;
		b=b+2;
	}
	
	public TestLock getTestLock(){
		synchronized (testLock) {
			if(testLock == null){
				testLock= new TestLock();
			}
			a=a+1;
			b=b+2;
		}
		return testLock;
	}
	
}
