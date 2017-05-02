package com.rajasekar.collections;

public class OuterClass {

	public static class StaticClass{
		int x,y;
		public StaticClass (int x, int y){
			this.x = x;
			this.y=y;
		}
		
		public String toString(){
			return "The value of X:"+x+" the value of y:"+y;
		}
		
	}
	
	public class NormalClass{
		
	}
	
	
	
}

