package com.rajasekar.collections;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack <String> stack = new Stack<>();
		stack.add("1");
		stack.add("2");
		stack.add("3");
		stack.add("4");

		for(String str: stack){
			System.out.println(str);
		}
		System.out.println(stack);
	}

}
