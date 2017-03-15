package com.rajasekar.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsTesting {

	public static void main(String[] args) {
		List <? super GenericProfile> profile = new ArrayList<>();
		addGenericMethod(profile, new Specific1Profile(1, "raja", "first name"));
		printGenericMethod((Collection<? extends GenericProfile>) profile);
		List <? super GenericProfile> myList = new ArrayList();
		myList.add(new Specific1Profile(1, "rama", "second name"));
	}
	
	
	public static void printMethod(List<?> testignList){
		String obj = testignList.get(0);
		
	}
	
	public static void printGenericMethod(Collection <? extends GenericProfile> collection){
		collection.stream().forEach(data -> System.out.println(data.toString()));
	}
	
	
	public static <T extends GenericProfile> void addGenericMethod(Collection <? super GenericProfile> collection,T genericProfile){
		collection.add(genericProfile);
	}

}
