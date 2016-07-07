package com.rajasekar;

public class Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean a = true;
		Boolean b = true;
		if(! ( a || b)){
			System.out.println("Inside X");
		}
		
		if(! a || b){
			System.out.println("Inside Y");
		}
	}

}
