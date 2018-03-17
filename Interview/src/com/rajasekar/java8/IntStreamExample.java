package com.rajasekar.java8;

import java.util.stream.IntStream;

public class IntStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IntStream.of(1,2,4,5).forEach(System.out::println);
		IntStream.rangent(0, 7).forEach(System.out::println);
	}

}
