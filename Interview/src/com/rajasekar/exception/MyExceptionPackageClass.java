package com.rajasekar.exception;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;

public class MyExceptionPackageClass {

	public static void main(String[] args) {
		/*List<String> list1 = new ArrayList<String>();
		list1.add("11");
		list1.add("12");
		List<String> list2 = new ArrayList<String>();
		list2.add("21");
		list2.add("22");
		
		List<List<String>> finalList = new ArrayList();
		finalList.add(list1);
		finalList.add(list2);
		Instant startTime = Instant.now();
		boolean value = finalList.parallelStream().map((data) -> {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
			}).flatMap(Collection::stream)
		.anyMatch((data) -> data.length()>0);
		Instant endTime = Instant.now();
		System.out.println(value);
		System.out.println(Duration.between(startTime, endTime).toMillis());*/
		
		String peerInterface = "u1/2";
		String [] peerArray = peerInterface.split("/");
		System.out.println(peerArray[0]+" "+peerArray[1]);
		
	}

}
