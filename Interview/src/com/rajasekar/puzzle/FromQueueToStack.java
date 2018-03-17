package com.rajasekar.puzzle;

import java.util.LinkedList;
import java.util.List;

class Stack <T> {
	
	private List<T> primaryList;
	private List<T> secondryList;
	public Stack(){
		primaryList = new LinkedList<T>();
		secondryList = new LinkedList<T>();
	}
	
	public void push(T element){
		primaryList = secondryList;
		secondryList = new LinkedList<T>();
		secondryList.add(element);
		for(T listElement: primaryList){
			secondryList.add(listElement);
		}
		

		
	}
	
	public T pop(){
		return secondryList.remove(0);
	}
	
}

public class FromQueueToStack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("rajasekar");
		stack.push("sathya");
		stack.push("remela");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push("selvam");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		

	}

}
