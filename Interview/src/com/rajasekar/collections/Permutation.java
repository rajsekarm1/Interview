package com.rajasekar.collections;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation _instance = new Permutation();
		ArrayList<String> result = _instance.stringPermutations("raj");
		result.forEach(System.out::println);
		
	}
	public ArrayList<String> stringPermutations(String s) {
	    ArrayList<String> result = new ArrayList<String>();
	    stringPermutations("", s, result); 
	    return result;
	}

	private void stringPermutations(String prefix, String suffix, List<String> results) {
		System.out.println("the value prefix:"+prefix+"  Suffix:"+suffix);
	    if (suffix.length() == 0) {
	        results.add(prefix);
	    } else {
	        for (int i = 0; i < suffix.length(); i++) {
	            stringPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, suffix.length()),results);
	        }
	    }
	}


	public List<int[]> listPermutations(int[] a) {
	    ArrayList<int[]> results= new ArrayList<int[]>();
	    listPermutations(a, 0, results);
	    return results;
	}

	private void listPermutations(int[] a, int start, List<int[]> result) {
	    if (start >= a.length) {
	        result.add(a.clone());
	    } else {
	        for (int i = start; i < a.length; i++) {
	            swap(a, start, i);
	            listPermutations(a, start+1, result);
	            swap(a, start, i);
	        }
	    } 
	}

	private void swap(int[] a, int i, int j) {
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	

}
