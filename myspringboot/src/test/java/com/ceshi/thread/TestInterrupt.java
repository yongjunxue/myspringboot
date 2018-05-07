package com.ceshi.thread;

public class TestInterrupt implements Runnable {
	public static void main(String[] args) throws InterruptedException {
//		Runnable r= new TestInterrupt();
//		Thread t=new Thread(r);
//		t.start();
//		System.out.println("1"+t.interrupted());
//		System.out.println("2"+t.isInterrupted());
//		Thread.sleep(1000);
//		t.interrupt();
//		System.out.println("3"+t.isInterrupted());
//		System.out.println("4"+t.interrupted());
//		System.out.println("5"+t.isInterrupted());
//		Thread.sleep(1000);
		
		
		
//-----------------------------------------------		
//		TestInt2 r= new TestInt2();
//		Thread t=new Thread(r);
//		t.start();
//		Thread.sleep(1000);
//		r.flag=false;
//		t.interrupt();
//-----------------------------------------------		
		TestInt3 r= new TestInt3();
		Thread t=new Thread(r);
		t.start();
		Thread.sleep(1000);
		t.interrupt();
//-----------------------------------------------	
		
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		System.out.println("do other thing");
	}
}
class TestInt2 implements Runnable {
	boolean flag=true;
	@Override
	public void run() {
		while(getFlag()){
			try {
				Thread.currentThread().sleep(10000);
				System.out.println("1");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("2");
			}
			System.out.println("3");
		}
	}

	private boolean getFlag() {
		System.out.println("4--"+"flag="+flag);
		return flag;
	}
	
}


class TestInt3 implements Runnable {
	@Override
	public void run() {
		while(!isInterrupted()){
			try {
				Thread.currentThread().sleep(10000);
				System.out.println("1");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("2");
//				Thread.currentThread().interrupted();
				Thread.currentThread().interrupt();
			}
			System.out.println("3");
		}
	}

	private boolean isInterrupted() {
//		boolean flag=Thread.currentThread().isInterrupted();
//		System.out.println("4--"+flag);
//		flag=Thread.currentThread().isInterrupted();
//		System.out.println("5--"+flag);
		
		
		boolean flag=Thread.currentThread().interrupted();
		System.out.println("4--"+flag);
		flag=Thread.currentThread().interrupted();
		System.out.println("5--"+flag);
		return flag;
	}
	
}
