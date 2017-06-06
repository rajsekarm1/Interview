package com.rajasekar.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class MyCustomThreadPool {
	
	private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
	private List<MyThread> threadPool = new ArrayList<MyThread>();
	
	private int size;
	
	public MyCustomThreadPool(int size){
		this.size = size;
		IntStream.of(0,size).boxed().forEach(data -> {
			threadPool.add(new MyThread(queue));
		});
		threadPool.stream().forEach(MyThread::start);
		
	}

	public void terminate(){
		threadPool.stream().forEach(MyThread::doStop);
	}
	
	public void enqueue(Runnable runnable){
		try {
			queue.put(runnable);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MyCustomThreadPool threadPool = new MyCustomThreadPool(10);
		threadPool.enqueue(getRunnableObj("Task 1"));
		threadPool.enqueue(getRunnableObj("Task 2"));
		threadPool.enqueue(getRunnableObj("Task 3"));
		threadPool.enqueue(getRunnableObj("Task 4"));
		threadPool.enqueue(getRunnableObj("Task 5"));

	}
	
	private static Runnable getRunnableObj(String taskName){
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("START:  " +taskName);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("END:  " +taskName);
			}
		};
		return runnable;
	}

}



class MyThread extends Thread{
	
	private Boolean isStopped=false;
	
	private BlockingQueue<Runnable> queue;
	
	public Boolean getIsStopped() {
		return isStopped;
	}

	public void setIsStopped(Boolean isStopped) {
		this.isStopped = isStopped;
	}
	
	public void doStop(){
		setIsStopped(true);
		interrupt();
	}

	public MyThread(BlockingQueue<Runnable> queue){
		this.queue=queue;
	}
	
	public void run(){
		while(!isStopped){
			try {
				Runnable runnable = queue.take();
				runnable.run();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
