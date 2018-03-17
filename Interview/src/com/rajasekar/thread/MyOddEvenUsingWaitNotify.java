package com.rajasekar.thread;

class PrinterOddEven{
	
	volatile boolean isOdd = true;
	
	int limit;
	
	int counter = 1;
	
	public PrinterOddEven(int limit) {
		super();
		this.limit = limit;
	}


	public synchronized void printOddNumber(){
		while(isOdd){
			if(counter<limit){
				System.out.println("counter Odd Number:"+counter);
				counter++;
				isOdd = false;
			}else{
				break;
			}
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public synchronized void printEvenNumber(){
		while(!isOdd){
			if(counter<limit){
				System.out.println("counter Even Number:"+counter);
				counter++;
				isOdd = true;
			}else{
				break;
			}
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}


public class MyOddEvenUsingWaitNotify {

	public static void main(String[] args) {
		PrinterOddEven printer = new PrinterOddEven(100);	
		Thread th1 = new Thread(()-> printer.printOddNumber());
		Thread th2 = new Thread(()-> printer.printEvenNumber());
		th1.start();
		th2.start();
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
