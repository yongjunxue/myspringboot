package com.ceshi.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TestForkJoin extends RecursiveTask<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3826606864213384381L;
	
	private static final int THRESHOLD = 10;
	long start;
	long end;
	public TestForkJoin(long start,long end){
		this.start=start;
		this.end=end;
	}
	static AtomicLong ato=new AtomicLong(0); //创建的子任务的总个数
	@Override
	protected Long compute() {
		long sum = 0;
		// 如果任务足够小就计算任务
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			ato.getAndIncrement();
		} else {
			// 如果任务大于阈值，就分裂成两个子任务计算
			long middle = (start + end) / 2L;
			TestForkJoin leftTask = new TestForkJoin(start, middle);
			TestForkJoin rightTask = new TestForkJoin(middle + 1, end);
			// 执行子任务
			leftTask.fork();
			rightTask.fork();
			// 等待子任务执行完，并得到其结果
			long leftResult=leftTask.join();
			long rightResult=rightTask.join();
			// 合并子任务
			sum = leftResult + rightResult;
		}
		return sum;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().sleep(10000);
		long aa=0;
		long bb=4000L;
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
		TestForkJoin task = new TestForkJoin(aa, bb);
		// 执行一个任务
		long start=System.currentTimeMillis();
		Future<Long> result = forkJoinPool.submit(task);
		try {
		System.out.println(result.get());
		} catch (InterruptedException e) {
			
		} catch (ExecutionException e) {
		
		}
		System.out.println("用时："+(System.currentTimeMillis()-start));
		
		start=System.currentTimeMillis();
		long sum=0;
		for(long i=aa;i<=bb;i++){
			sum+=i;
		}
		System.out.println(sum);
		System.out.println("用时："+(System.currentTimeMillis()-start));
		System.out.println(ato);
	}

}
