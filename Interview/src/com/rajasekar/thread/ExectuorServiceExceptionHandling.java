package com.rajasekar.thread;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExectuorServiceExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instant startInstant = Instant.now();
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Future<?> future = service.submit(() -> {
			try{
				Thread.sleep(100000);
				
			}catch(Exception exec){
				throw exec;
			}
			throw new IOException();
		});
		Future<?> future2 =  service.submit(() -> {
			System.out.println("second task");
		});
		
			try {
				future.get(10, TimeUnit.SECONDS);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				future.cancel(true);
				e.printStackTrace();
			}
			catch (ExecutionException exExec){
				System.out.println("coming here");
				exExec.getCause().printStackTrace();
				System.out.println(exExec.getCause());
			}
			try {
				future2.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			future2.cancel(true);
			Long endMillSeconds = System.currentTimeMillis();
			Instant endInstant = Instant.now();
			Duration timeElapsed = Duration.between(endInstant,startInstant);
			System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
			service.shutdown();
	}

}
