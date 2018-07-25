package com.example.java8concurrency.java.before5;

/**
 * 可完成的{@link Runnable}
 * @author Administrator
 *
 */
public class CompletableRunnableMain {
	
	public static void main(String[] args) throws InterruptedException {
		CompletableRunnable runnable=new CompletableRunnable();
		
		
		Thread thread=new Thread(runnable,"Sub");
		
		thread.start();
		//等着线程执行结束,串性操作！
		thread.join();
		
		System.out.printf("[Thread : %s]Starting...\n",Thread.currentThread().getName());
		
		System.out.printf(" runnable is completed : %s\n",runnable.isCompleted());
		
	}
	private static class CompletableRunnable implements Runnable{
		private volatile boolean completed;

		@Override
		public void run() {
			System.out.printf("[Thread : %s]hello world...\n",
					Thread.currentThread().getName());
			completed=true;
		}

		public boolean isCompleted() {
			return completed;
		}

		
		
	}

}
