package com.rajasekar.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableVsHashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		Map<String,String> table = new Hashtable<>();
		table.put(null, null);
		System.out.println(table.size());*/
		
		Map<String,String> table = new HashMap<>();
		table.put(null, "test");
		System.out.println(table.get(null));
		
		
	}

}
