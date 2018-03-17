package com.rajasekar.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StreamsInMultiThreaded {
	
	private List<Integer> intList = new ArrayList<>();
	
	//private ExecutorService service =Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StreamsInMultiThreaded thisObj = new StreamsInMultiThreaded();
		thisObj.submitTask();
		thisObj.streamIteration();

	}
	
	private void streamIteration() {
		System.out.println("started stream Iteration");
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		intList.stream().forEach((data) -> {
			intList.add(2000);
			System.out.println("From stream:"+data);
		});
		
	}

	public void submitTask(){
		Thread th = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println(Thread.currentThread().getName()+" Insert:"+i);
					intList.add(i);
				}
			}
		});
		th.setName("Submit Task Thread");
		th.start();
	}

}
 