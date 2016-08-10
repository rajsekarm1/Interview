package com.rajasekar.heap;

import java.util.Arrays;

public class HeapSort {
	
	
	static int array[] = new int[]{10,45,2,3,6,7,1,11,23};
	
	protected static int  getLeftChild(int parent,int endIndex){
		if(parent<0 || parent >endIndex){
			return -1;
		}
		int childIndex = 2*parent +1;
		if(childIndex>endIndex){
			return -1;
		}
		return childIndex;
	}
	
	protected static void printElement(){
		System.out.println(Arrays.toString(array));
	}
	
	protected static int getParent(int counter){
		if(counter<0){
			return -1;
		}
		int parentIndex = (counter-1)/2;
		return parentIndex;		
	}
	
	protected static void swap(int sourceIndex, int targetIndex){
		int temp = array[sourceIndex];
		array[sourceIndex] = array[targetIndex];
		array[targetIndex] = temp;
	}
	
	protected static int getRightChild(int parent,int endIndex){
		if(parent<0 || parent >endIndex){
			return -1;
		}
		int childIndex = 2*parent +2;
		if(childIndex>endIndex){
			return -1;
		}
		return childIndex;
	}

	public static void main(String[] args) {
		printElement();
		heapify();
		printElement();
		heapSort(array.length-1);
		printElement();

	}
	
	

	private static void heapSort(int index) {
		while(index!=-1){
			swap(0,index);
			index--;
			precolateDown(0,index);
		}
		
	}

	private static void heapify() {
		int index = array.length/2;
		while(index>=0){
			precolateDown(index,array.length-1);
			index--;
		}
		
	}
	
	private static void precolateDown(int index,int endIndex){
		int leftIndex = getLeftChild(index,endIndex);
		int rightIndex = getRightChild(index,endIndex);
		int tempIndex=-1;
		if(leftIndex!=-1 && rightIndex!=-1){
			if(array[leftIndex]>array[rightIndex]){
				tempIndex=leftIndex;
			}else{
				tempIndex=rightIndex;
			}
		}else if(leftIndex!=-1){
			tempIndex=leftIndex;
		}else if(rightIndex!=-1){
			tempIndex=rightIndex;
		}
		if(tempIndex==-1){
			return;
		}
		if(array[tempIndex]>array[index]){
			swap(tempIndex,index);
			precolateDown(tempIndex,endIndex);
		}
		
	}
	

}
