package com.rajasekar.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


 

public class FutureTaskExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService execService = Executors.newFixedThreadPool(2);
		FutureTask<String> futureTask1 = new FutureTask<String>(() -> "FutureTask 1");
		FutureTask<String> futureTask2 = new FutureTask<String>(() -> "FutureTask 2");
		execService.submit(futureTask1);
		execService.submit(futureTask2);
		System.out.println("Task1"+futureTask1.get());
		System.out.println("Task2"+futureTask2.get());
		execService.shutdown();
		
	}

}
