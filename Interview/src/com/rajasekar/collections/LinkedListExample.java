package com.rajasekar.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new LinkedList<>();
		list.add("a");
		list.add("b");
		Queue<String> queue = (Queue)list;
		queue.poll();
		System.out.println(queue);
	}

}
