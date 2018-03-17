package com.rajasekar.puzzle;

public class FindNumberOfOnes {

	public static void main(String[] args) {
		int x = 255;
		int sum =0;
		while(x>0){
			sum+= x & 1;
			x = x>>1;
		}
		System.out.println(sum);
	}

}
