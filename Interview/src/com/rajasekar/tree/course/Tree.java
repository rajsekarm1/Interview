package com.rajasekar.tree.course;

public interface Tree <T extends Comparable<T>>{
	
	public void insert(T newData);
	public T getMin();
	public T getMax();
	public void traverseInOrder();

}
