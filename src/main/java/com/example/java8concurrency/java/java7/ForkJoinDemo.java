package com.example.java8concurrency.java.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Fork/Join 示例
 * @author Administrator
 *
 */
public class ForkJoinDemo {
	
	
	public static void  main(String[] args) {
		//并行： 多核心参与
		//并发： 一同参与
		//ForkJoin 线程池  ForkJoinPool
		System.out.printf("当前公用ForkJoinPool线程池 并行数:%d\n",ForkJoinPool.getCommonPoolParallelism());
		System.out.printf("当前CPU处理器数:%d\n",Runtime.getRuntime().availableProcessors());
		//与ThreadPoolExecutor类似
		ForkJoinPool forkJoinPool= new ForkJoinPool();
		forkJoinPool.invoke(new RecursiveAction() {
			
			@Override
			protected void compute() {
				System.out.printf("[Thread : %s]hello world...\n",
						Thread.currentThread().getName());
				
			}
		} );
		
		
		forkJoinPool.shutdown();
		
	}

}
