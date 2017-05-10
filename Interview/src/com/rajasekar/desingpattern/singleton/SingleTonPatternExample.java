package com.rajasekar.desingpattern.singleton;

public class SingleTonPatternExample {
	
	private static volatile SingleTonPatternExample _instance = null;
	
	private SingleTonPatternExample(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SingleTonPatternExample getInstance(){
		if(_instance == null){
			synchronized (SingleTonPatternExample.class) {
				if(_instance == null){
					_instance = new SingleTonPatternExample();
				}
			}
		}
		return _instance;
	}

}
