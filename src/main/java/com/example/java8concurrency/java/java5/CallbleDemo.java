package com.example.java8concurrency.java.java5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallbleDemo {
	
	/**
	 * Callable 是有返回值,相当于Runnable
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @see Callable
	 * @see Runnable
	 */
	public static void  main(String[] args) throws InterruptedException, ExecutionException {
		
		
		//执行器服务，线程池(ThreadPoolExecutor)是他的一种实现
		//线程池是线程复用
		ExecutorService executorService = 
				Executors.newFixedThreadPool(1);
		
		Future<String> future =executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "[Thread : "+Thread.currentThread().getName()+"]hello world";
			}
		});
		String value=future.get();
		System.out.println(value);
		executorService.shutdown();
	}

}
