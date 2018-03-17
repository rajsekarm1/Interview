package com.rajasekar.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsTesting {

	public static void main(String[] args) {
		printProfile(new Specific1Profile(0,"specific","specificProperty"));
		printProfile(new GenericProfile(0,"specific"));
		addNumbers(new ArrayList<Number>());
		ArrayList<Number> numList = new ArrayList<>();
		numList.add(new Integer(1));
	}
	
	
	//UnBounded Generics example
	public static <T> void printProfile(T profile){
		
	}
	
	 public static <T> void exchange(T[] array, int src, int dest){
		 
	 }
	 
	//Upper Bounded Generics
	public static <T extends GenericProfile> void printProfile(T profile){
		
	}
	
	//Lower Bound Generics
	public static void addNumbers(List<? super Integer> list) {
	    for (int i = 1; i <= 10; i++) {
	        list.add(i);
	    }
	}
	
	
	
	public static void printMethod(List<?> testignList){
		//String obj = testignList.get(0);
		
	}
	
	public static void printGenericMethod(Collection <? extends GenericProfile> collection){
		collection.stream().forEach(data -> System.out.println(data.toString()));
	}
	
	
	public static <T extends GenericProfile> void addGenericMethod(Collection <? super GenericProfile> collection,T genericProfile){
		collection.add(genericProfile);
	}

}
