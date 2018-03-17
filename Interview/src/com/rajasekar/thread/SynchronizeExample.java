package com.rajasekar.thread;

public class SynchronizeExample {
	
	private int counter =0;
	public void instanceMethod(){
		/*try {
			//System.out.println("START:"+Thread.currentThread().getName());
			//Thread.sleep(1000);
			//System.out.println("END:"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		for(int i=0;i<10000;i++){
			counter = counter + 1;
		}
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		SynchronizeExample example = new SynchronizeExample();
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				example.instanceMethod();
				
			}
		});
		t.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				example.instanceMethod();
				
			}
		});
		t2.start();
		t.join();
		t2.join();
		System.out.println("Counter value:"+ example.counter);
	}

}
