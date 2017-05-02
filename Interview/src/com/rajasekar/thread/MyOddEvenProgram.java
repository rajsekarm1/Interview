package com.rajasekar.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

enum OddOrEven{
	Odd,
	Even;
}

public class MyOddEvenProgram extends Thread{
	
	private OddOrEven oddOrEven;
	private Lock lock;
	private Condition lockCondition;
	private static AtomicBoolean isOddNumber = new AtomicBoolean(true);
	
	public MyOddEvenProgram(OddOrEven oddOrEven, Lock lock, Condition lockCondition){
		this.oddOrEven = oddOrEven;
		this.lock = lock;
		this.lockCondition = lockCondition;
		
	}
	
	@Override
	public void run() {
		int i = (oddOrEven == OddOrEven.Odd)?1:2;
		for(;i<10;){
			//System.out.println(this.currentThread().getName() +oddOrEven + "  --- "+ i);
			if(oddOrEven == OddOrEven.Odd){
				printOddNumber(i);
			}
			if(oddOrEven == OddOrEven.Even){
				printEvenNumber(i);
			}
			i=i+2;
		}
		
	}
	private void printEvenNumber(int i) {
		lock.lock();
		while(isOddNumber.get()){
			try {
				lockCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Even Number:"+i);
		isOddNumber.set(true);
		lockCondition.signalAll();
		lock.unlock();
	}

	private void printOddNumber(int i) {
		lock.lock();
		while(!isOddNumber.get()){
			try {
				lockCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Odd Number:"+i);
		isOddNumber.set(false);
		lockCondition.signalAll();
		lock.unlock();
	}

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		MyOddEvenProgram oddThread = new MyOddEvenProgram(OddOrEven.Odd,lock, condition);
		MyOddEvenProgram evenThread = new MyOddEvenProgram(OddOrEven.Even, lock, condition);
		oddThread.start();
		evenThread.start();
		

	}

	

}
