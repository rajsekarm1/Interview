package com.rajasekar.heap;

public class MinHeap<T extends Comparable<T>> extends Heap<T> {

	protected MinHeap(Class className, int maxSize) {
		super(className, maxSize);		
	}
	
	protected MinHeap(Class className) {
		super(className);		
	}

	@Override
	public T getElement() {
		if(counter>-1)
			return (T)array[0];
		else{
			throw new RuntimeException("There are no elements");
		}
	}

	@Override
	public T removeElement() {
		T min = array[0];
		if(counter!=0){
			array[0]=array[counter-1];
			System.out.println("siftDown operation");
			counter--;
			siftDown(0);
			
		}
		return min;
	}
	
	protected void siftDown(int index){
		if(index<0){
			return;
		}
		int leftIndex = getLeftChild(index);
		int rightIndex = getRightChild(index);
		int replaceIndex = -1;
		if(leftIndex!=-1 && rightIndex!=-1 ){
			replaceIndex = array[leftIndex].compareTo(array[rightIndex])<0?leftIndex:rightIndex;
		}else if(rightIndex!=-1){
			replaceIndex = rightIndex;
		}else if(leftIndex!=-1){
			replaceIndex = leftIndex;
		}else{
			return;
		}
		if(array[index].compareTo(array[replaceIndex])>0){
			swap(index,replaceIndex);
		}
		printElements();
		siftDown(replaceIndex);
	}

	@Override
	public void insertElement(T element) {
		if(counter==0){
			array[counter]= element;			
		}else{
			array[counter]= element;
			siftUp(counter);
		}
		counter++;
	}

	private void siftUp(int counter) {
		int parentIndex = getParent(counter);
		while(parentIndex!=-1){
			T parentValue = array[parentIndex];
			if(parentValue.compareTo(array[counter])>0){
				swap(parentIndex,counter);
				counter=parentIndex;
				parentIndex = getParent(parentIndex);
				
			}
			else{
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		Heap<Integer> intHeap = new MinHeap<>(Integer.class);
		intHeap.insertElement(102);
		intHeap.printElements();
		intHeap.insertElement(11);
		intHeap.printElements();
		intHeap.insertElement(8);
		intHeap.printElements();
	    intHeap.insertElement(2);
		intHeap.printElements();
		intHeap.insertElement(9);
		intHeap.printElements();
		intHeap.insertElement(10);
		intHeap.printElements();
		intHeap.insertElement(13);
		intHeap.printElements();
		intHeap.removeElement();
		intHeap.printElements();
		intHeap.removeElement();
		intHeap.printElements();
	}

}
