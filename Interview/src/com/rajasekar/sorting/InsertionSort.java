package com.rajasekar.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort {

	static int data[] = {43,12,10,32,98,22,22,28,99,11,101};
	
	public static void main(String[] args) {
		int counter =0;
		printElement();
		for(int i=0;i<data.length;i++){
			int j=i-1;
			int temp = data[i];
			for(;j>=0;j--){
				counter++;
				if(temp<data[j]){
					data[j+1]=data[j];					
				}else{
					break;
				}
			}
			data[j+1]=temp;
			
			printElement();
		}		
		System.out.println("counter value:"+counter);
		printElement();
	}
	
	public static void printElement(){
		List<Integer> intList =Arrays.stream(data).boxed().collect(Collectors.toList());
		System.out.println(intList);
	}

}
