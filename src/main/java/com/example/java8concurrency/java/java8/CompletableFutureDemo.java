package com.example.java8concurrency.java.java8;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * {@link CompletableFuture} Demo
 * 
 * 
 * @author Administrator
 * @see CompletionStage
 */
public class CompletableFutureDemo {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
//		1.完成操作
//		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
//		
//		completableFuture.complete("Hello World");
//		
//		String value = completableFuture.get();
//		
//		System.out.println(value);
		
		
	  //2.异步操作,阻塞操作
//		
//		CompletableFuture AsyncCompletableFuture = CompletableFuture.runAsync(()-> {
//			System.out.println("Hello world");
//		});
//	
//		//仍然是阻塞操作
//		 AsyncCompletableFuture.get();
	    
		//3.异步操作,阻塞操作
		
//		CompletableFuture<String> supplyAsyncCompletableFuture = CompletableFuture.supplyAsync(()-> {
//			//获取数据操作，假设来自于数据库
//				return String.format("[Thread : %s]hello world...\n",
//						Thread.currentThread().getName());
//		});
//		
//		String value = supplyAsyncCompletableFuture.get();
//		
//		System.out.println("value = "+value);
//
//		System.out.println("Starting...");
		
		//4.合并操作
		
		
		CompletableFuture  combinedCompletableFuture = CompletableFuture.supplyAsync(()-> {
			//获取数据操作，假设来自于数据库
				return String.format("[Thread : %s]hello world...",
						Thread.currentThread().getName());
		}).thenApply(value ->{
			
			return value + " - 来自于数据库";
			
		}).thenApply(value -> {
			
			return value + " at " + LocalDate.now();
			
		}).thenApply(value -> {
			System.out.println(value);
			return value;
			
		}).thenRun(() -> {
			//commit 操作
			System.out.printf("操作结束[Thread : %s]hello world...\n",Thread.currentThread().getName());
		})
//		.exceptionally(e -> {
//			
//		})
		; //reacive -> flatMap
		
		while(!combinedCompletableFuture.isDone()) {
			
		}
		
//         combinedCompletableFuture.get();

		System.out.println("Starting...");
		
		
	}

}
