package com.rajasekar.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stringcmp {

	public static void main(String[] args) {
		
		String one = "1";
		String two ="11";
		List<String> strList = new ArrayList<>();
		strList.add(one);
		strList.add(two);
		strList.add("9");
		strList.add("18");
		Collections.sort(strList);
		System.out.println(strList);
	}
	


}
