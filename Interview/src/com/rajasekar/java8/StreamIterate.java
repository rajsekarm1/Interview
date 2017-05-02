package com.rajasekar.java8;

import java.util.function.Function;
import java.util.stream.Stream;

public class StreamIterate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 10;
		
		System.out.println(StreamIterate.sequentialSum,10_000_000));
		System.out.println(Runtime.getRuntime().availableProcessors());

	}
	
	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest) fastest = duration;
		}
		return fastest;
	}
	
	public static int sequentialSum(int n){
		return Stream.iterate(1, i->i+1)
				.limit(n)
				.reduce(0,Integer::sum);
	}

}
