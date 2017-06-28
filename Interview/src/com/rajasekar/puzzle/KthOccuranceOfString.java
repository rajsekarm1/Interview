package com.rajasekar.puzzle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KthOccuranceOfString {

	public static void main(String[] args) {
		Map<String,Integer> stringMap = parseStringWithEachWord("raj raj raj sathya naveen muthusamy selvam selvam");
		Set<Map.Entry<String,Integer>> setString = stringMap.entrySet();
		List<Map.Entry<String,Integer>> list = setString.stream().sorted(KthOccuranceOfString::compareStringOccurance).collect(Collectors.toList());
		System.out.println(list);
	}
	
	public static int compareStringOccurance(Map.Entry<String, Integer> m1, Map.Entry<String,Integer> m2){
		return m1.getValue().compareTo(m2.getValue());
	}
	 
	public static Map<String, Integer> parseStringWithEachWord(String wholeString){
		String [] strArray = wholeString.split("\\s+");
		Stream<String> stringStream = Arrays.stream(strArray);
		Map<String,Integer> map = stringStream.collect(Collectors.toMap(Function.identity(), data -> new Integer(1), (x,y) -> x + 1));
		System.out.println(map);
		return map;
	}

}
