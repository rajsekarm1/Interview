package com.rajasekar.datastrcuture.linkedlist;

import java.util.Arrays;
import java.util.Stack;

class Node<T extends Comparable<T>>{
	
	T data;
	public Node<T> nextNodeAddr;
	public Node<T> downNodeAddr;
	
	public String toString(){
		return "the node:["+data+"]";
	}
}

public class LinkedList<T extends Comparable<T>> {
	Node<T> head;
	
	public void reverseLinkedList(){
		Node<T> current=head;
		Node<T> previous=null;
		Node<T> next=null;
		while(current!=null){
			next = current.nextNodeAddr;			
			current.nextNodeAddr = previous;
			previous=current;
			current = next;
		}
		head=previous;
	}
	
	
	public LinkedList() {
		super();
	}


	public LinkedList(T dataArray[]){
		if(dataArray!=null){
			Arrays.stream(dataArray).forEach(data -> this.add(data));
		}
	}
	
	public void add(T data){
		Node<T> current = head;
		while(current!=null && current.nextNodeAddr!=null){
			current = current.nextNodeAddr;			
		}
		Node<T> newNode = new Node<T>();
		newNode.data=data;
		
		if(head==null){
			head = newNode;
		}else{
			current.nextNodeAddr=newNode;
		}
	}
	
	public void printMiddleOfLinkedList(){
		Node<T> slowPtr=head;
		Node<T> fastPtr=head;
		while(fastPtr!=null && fastPtr.nextNodeAddr!=null){
			slowPtr=slowPtr.nextNodeAddr;
			fastPtr=fastPtr.nextNodeAddr.nextNodeAddr;
		}
		if(slowPtr!=null){
			System.out.println("the middle element:"+slowPtr.data);
		}
	}
	
	public void print(){
		StringBuilder strBuilder = new StringBuilder();
		Node<T> current = head;
		while(current!=null){
			strBuilder.append("-->  "+current.data);
			current=current.nextNodeAddr;
		}
		System.out.println("List value:"+strBuilder.toString());
	}
	
	public void deleteElementWhoseSumisZero(){
		Node<T> current = head;
		Stack<Node<T>> stack = new Stack<>();
		while(current!=null){
			if((int)current.data < 0){
				int sum = (int)current.data;
				while(!stack.isEmpty()){
					Node<T> temp = stack.pop();
					sum+=(int)temp.data;
					if(sum == 0){
						if(stack.isEmpty()){
						}else{
							Node<T> tmpNode = stack.peek();
							tmpNode.nextNodeAddr=current.nextNodeAddr;
						}
						break;
					}
				}
			}else{
				stack.push(current);
			}
			current = current.nextNodeAddr;
		}
		
	}
	
	
	
	
	public static void main(String args[]){
		LinkedList<Integer> list = new LinkedList<>(new Integer[]{4, 6, -6, 8, 9, 10, -19, 10, -18, 20, 25});
		//int [] intArray = ;
		
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
		list.print();
		//list.reverseLinkedList();
		//list.print();
		//list.printMiddleOfLinkedList();
		list.deleteElementWhoseSumisZero();
		list.print();
	}
}
