package com.rajasekar.sorting;

public class MergeSort {
	
	
	static int array[] = new int[] {10,23,1,49,28,29,43,100,34};
	static int tempArray[] = new int[array.length];

	public static void main(String[] args) {
		
		mergeSort(0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	    

	}

	
	public static void mergeSort(int startIndex, int endIndex){
		if(startIndex<endIndex){
			//int middleIndex = startIndex + (endIndex-startIndex)/2;
			int middleIndex = startIndex + (endIndex-startIndex)/2;
			System.out.println("The middle element:"+middleIndex);
			mergeSort(startIndex,middleIndex);
			mergeSort(middleIndex+1,endIndex);
			merge(startIndex,middleIndex,endIndex);
		}		
	}
	
	
	public static void merge(int startIndex, int middleIndex, int endIndex){
		
		for(int i=startIndex;i<=endIndex;i++){
			tempArray[i]=array[i];
		}
		int i = startIndex;
		int j=middleIndex+1;
		int k = startIndex;
		while(i<= middleIndex && j<=endIndex){
			if(tempArray[i]<=tempArray[j]){
				array[k]= tempArray[i];
				i++;
			}else{
				array[k]= tempArray[j];
				j++;
			}
			k++;
		}
		while (i <= middleIndex) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
		
		
	}
	
	

}
