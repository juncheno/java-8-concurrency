package com.example.java8concurrency.java.java5;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	public static void  main(String[] args) {
		
		//执行器，线程池(ThreadPoolExecutor)是他的一种实现
		Executor executor = Executors.newFixedThreadPool(1);
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.printf("[Thread : %s]hello world...\n",
						Thread.currentThread().getName());
				
			}
		});
		
		//合理的关闭线程池
		if(executor instanceof ExecutorService ) {
			ExecutorService exService=ExecutorService.class.cast(executor);
			exService.shutdown();
		}
		//java 5  开始实施 AutoCloseable, I/O JDBC
	}

}
