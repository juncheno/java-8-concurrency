package com.example.java8concurrency.java.before5;
/**
 * Java Thread/Runnable 编程模式(Java5 之前)
 * @author Administrator
 *
 */
public class ThreadMain {
 public static void  main(String[] args) {
	 
	 boolean finished=false;
//	 AtomicBoolean 是 java5
	 //子线程
	 Thread thread = new Thread(new Runnable() {
		/**
		 * synchronized 关键字是编程语言修饰符号
		 */
		@Override
		public synchronized void run() {
			System.out.printf("[Thread : %s]hello world...\n",
					Thread.currentThread().getName());
//			finished=true;
		}
	},"sub"); 
	 
	 thread.start();
	 System.out.printf("[Thread : %s]Starting...\n",Thread.currentThread().getName());
 }
}
