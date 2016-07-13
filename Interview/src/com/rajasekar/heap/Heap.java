package com.rajasekar.heap;

import java.lang.reflect.Array;

public abstract class Heap <T extends Comparable<T>> {
	
	protected T array[];
	
	protected int counter = 0;
	
	protected final int MAX_SIZE = 40;
	
	protected Heap(Class className){
		array = (T[]) Array.newInstance(className, MAX_SIZE);
	}
	
	protected Heap(Class className, int maxSize){
		array = (T[]) Array.newInstance(className, maxSize);
	}
	
	public abstract T getElement();
	
	public abstract T removeElement();
	
	public abstract void insertElement(T element);
	
	protected int getParent(int counter){
		if(counter<0){
			return -1;
		}
		int parentIndex = (counter-1)/2;
		return parentIndex;		
	}
	
	protected int getLeftChild(int parent){
		if(parent<0 || parent >=counter){
			return -1;
		}
		int childIndex = 2*parent +1;
		if(childIndex>=counter){
			return -1;
		}
		return childIndex;
	}
	
	protected void swap(int sourceIndex, int targetIndex){
		T temp = array[sourceIndex];
		array[sourceIndex] = array[targetIndex];
		array[targetIndex] = temp;
	}
	
	protected int getRightChild(int parent){
		if(parent<0 || parent >=counter){
			return -1;
		}
		int childIndex = 2*parent +2;
		if(childIndex>=counter){
			return -1;
		}
		return childIndex;
	}
	
	protected void printElements(){
		System.out.print("Element values:");
		for(int i=0;i<counter;i++){
			System.out.print("-"+array[i]);
		}
		System.out.println(" ");
	}
	
	public static void main(String args[]){
		System.out.println(0/2);
	}

}
