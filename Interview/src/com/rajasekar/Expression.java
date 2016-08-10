package com.rajasekar;

public class Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ab[] = {0,0,0,0};
		System.out.println(ab[2]);
		
		testMethod(ab);
		
		Boolean a = true;
		Boolean b = true;
		if(! ( a || b)){
			System.out.println("Inside X");
		}
		
		if(! a || b){
			System.out.println("Inside Y");
		}
	}

	private static void testMethod(int[] a) {
		a[2]=40;
		
	}

}
