package com.rajasekar.puzzle;

public class NumberOfOnesInBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i =3;
		int one=0;
		while(i!=0){
			int temp = i & 1;
			if(temp==1){
				one++;
			}
			i = i >>1;
		}
		
		System.out.println(one);
	}

}
