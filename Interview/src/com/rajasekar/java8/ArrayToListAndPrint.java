package com.rajasekar.java8;

import java.util.Arrays;
import java.util.stream.Collectors;

class NameAndValuePair{
	String name;
	String value;
	
	public NameAndValuePair(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	
}

public class ArrayToListAndPrint {

	public static void main(String[] args) {
		NameAndValuePair nvp1 = new NameAndValuePair("name1","value1");
		NameAndValuePair nvp2 = new NameAndValuePair("name2","value2");
		NameAndValuePair [] nvpArray = new NameAndValuePair[] {nvp1,nvp2};
		System.out.println(Arrays.stream(nvpArray).map(data -> data.name+":"+data.value).collect(Collectors.joining(",")));
	}

}
