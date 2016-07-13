package com.rajasekar.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
	
	static int data[] = {43,12,10,32,98,46,22,28,99,100,101};
	
	//Time complexity = O(N^2)
	//Space Complexity = O(1)
	//O(N^2) swaps. 
	//It is stable sort as entities which are equal might be re-arranged. 
	

	public static void main(String[] args) {
		printElement();
		for(int i=0;i<data.length;i++){
			boolean isSwapped =false;
			for(int j=0;j<data.length-i-1;j++){
				
				if(data[j]>data[j+1]){
					isSwapped = true;
					swapElement(j,j+1);
				}				
			}
			if(!isSwapped){
				System.out.println( " i value"+i+"Boolean value:"+isSwapped);
				break;
			}
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
