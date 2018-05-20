package com.rajasekar.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Aggregator implements Runnable {
	public void run(){
		System.out.println("Aggregator START: Run Method");
		
		
		System.out.println("Aggreator END: Run Method");
	}
}

class BarrierLogic implements Runnable{
	
	private CyclicBarrier barrier = null;
	public BarrierLogic(CyclicBarrier cyclicBarrier){
		this.barrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ ":BarrierLogic START: run method");
		try {
			Thread.sleep(1000);
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ ":BarrierLogic END: run method");
	}
	
}



public class CyclicBarrierExample {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new Aggregator());
		for(int i=0;i<12;i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread t = new Thread(new BarrierLogic(barrier));
			t.setName(i+"-- Thread");
			
			t.start();
		}
		System.out.println("main Thread");
	}

}
