package com.rajasekar.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*; 

public class SelectionSort {
	
	static int data[] = {43,12,10,32,98,46,22,28};

	//Time complexity = O(N^2)
	//Space Complexity = O(1)
	//O(N) swaps. 
	//It is not stable sort as entities which are equal might be re-arranged. 
	public static void main(String[] args) {
		printElement();
		for(int i=0;i<data.length;i++){
			int smallIndex=i;
			for(int j=i+1;j<data.length;j++){
				if(data[j]<data[smallIndex]){
					smallIndex=j;
				}
				
			}
			swapElement(i, smallIndex);
		}
		
		printElement();

	}
	
	public static void printElement(){
		List<Integer> intList =Arrays.stream(data).boxed().collect(Collectors.toList());
		System.out.println(intList);
	}
	
	public static void swapElement(int srcIndex, int targetIndex){
		int temp = data[srcIndex];
		data[srcIndex] = data[targetIndex];
		data[targetIndex] = temp;
	}

}
