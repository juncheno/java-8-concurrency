package com.example.java8concurrency.java.java7;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.LongAdder;

/**
 * 1-10累加
 * @author Administrator
 *
 */
public class ForkJoinDemo2 {
	
	
	public static void  main(String[] args) {
		//并行： 多核心参与
		//并发： 一同参与
		//ForkJoin 线程池  ForkJoinPool
		System.out.printf("当前公用ForkJoinPool线程池 并行数:%d\n",ForkJoinPool.getCommonPoolParallelism());
		System.out.printf("当前CPU处理器数:%d\n",Runtime.getRuntime().availableProcessors());
		//与ThreadPoolExecutor类似
		ForkJoinPool forkJoinPool= new ForkJoinPool();
		
	    List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//累加对象
	    LongAdder longAdder= new LongAdder();
	    
		//RecursiveAction 递归操作
		AddTask  addTask=new AddTask(nums, longAdder);
		
		forkJoinPool.invoke(addTask);
		
		forkJoinPool.shutdown();
		
		System.out.println(nums+"累加的结果: "+longAdder);
		
	}
	
	
	
	private static class AddTask extends RecursiveAction{
        
		
		private final   List<Integer> nums;
		
		//聚合器
		private final LongAdder longAdder;
		
		
		public AddTask(List<Integer> nums, LongAdder longAdder) {
			super();
			this.nums = nums;
			this.longAdder = longAdder;
		}
		@Override
		protected void compute() {

			int size = nums.size();
			
			if(size > 1) {
				//二分部分数
				int parts = size / 2;
//				int offset = 0;
				
				//左半部
				List<Integer> leftpart = nums.subList(0, parts);
				AddTask  leftTask=new AddTask(leftpart, longAdder);
				//右半部
				List<Integer> rightpart = nums.subList(parts, size);
				AddTask  rightTask=new AddTask(rightpart, longAdder);
				
			    invokeAll(leftTask, rightTask);

				
			}else {//当前元素只有1个
				
				if(size==0) {//保护
					return;
				}
				
				Integer value = nums.get(0);
				
				longAdder.add(value.intValue());
				
			}
				
		
			
			//仅只有一个元素
			
			
			
		}
		
	}

}
