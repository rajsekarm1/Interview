package com.rajasekar.datastrcuture.linkedlist;

class Node<T>{
	T data;
	public Node<T> nextNodeAddr;
	public Node<T> downNodeAddr;	
}

public class LinkedList<T> {
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
	
	public void print(){
		StringBuilder strBuilder = new StringBuilder();
		Node<T> current = head;
		while(current!=null){
			strBuilder.append("-->"+current.data);
			current=current.nextNodeAddr;
		}
		System.out.println("List value"+strBuilder.toString());
	}
	
	public static void main(String args[]){
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.print();
		list.reverseLinkedList();
		list.print();
	}
}
