package com.rajasekar.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTask implements Callable<Object>{
	
	private String taskName;
	
	public MyTask(String taskName) {
		super();
		this.taskName = taskName;
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Processing the task:"+taskName);
		return null;
	}
}

public class ExecutorServiceExample {

	public static void main(String[] args) {
		ExecutorService fixedThreadService = Executors.newSingleThreadExecutor();
		fixedThreadService.submit(new MyTask("Task1"));
		fixedThreadService.submit(new MyTask("Task2"));
		fixedThreadService.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				System.out.println("Execute method");
				return null;
			}
		});
		try {
			
			Thread.sleep(3000);
			fixedThreadService.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
