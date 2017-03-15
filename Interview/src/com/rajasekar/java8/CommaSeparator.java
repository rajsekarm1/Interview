package com.rajasekar.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;

public class CommaSeparator {

	public static <T> void main(String[] args) {
		List<String> strList = Arrays.asList("rajasekar","naveen","muthusamy","selvam","sathya","balaji");
		System.out.println(strList.stream().collect(joining(",")));
		StringJoiner joiner = new StringJoiner(",","[","]");
		strList.stream().forEach(joiner::add);
		System.out.println(joiner.toString());
		System.out.println(strList.stream().collect(joining(",")));
		Collector<Object, ?, List<Object>> coll = Collectors.toList();
		new CommaSeparator().addToCollection(new ArrayList<Number>());
		List<T> listNumber = new ArrayList<T>();
		listNumber.add(0, new Integer(10));
		List<Integer> intList = new ArrayList<Integer>();
		new CommaSeparator().consumeFromCollection(intList);
		new CommaSeparator().addToCollection(listNumber);
	}
	
	public void  addToCollection(Collection<? super Number>  number){
		number.add(new Integer(10));
	}
	
	public void consumeFromCollection(Collection <? extends Number> number){
		number.forEach(System.out::println);
		
	}

}
