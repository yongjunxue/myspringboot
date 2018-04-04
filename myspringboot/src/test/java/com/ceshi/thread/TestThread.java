package com.ceshi.thread;

public class TestThread implements Runnable{

	@Override
	public void run() {
		System.out.println("a");
		System.out.println("b");
	}
	public static void main(String[] args) {
		new Thread(new TestThread()).start();
	}
}


