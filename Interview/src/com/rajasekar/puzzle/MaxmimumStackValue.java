package com.rajasekar.puzzle;

class Node<T> {
	T value;
	Node<T> nextNode;
	Node<T> maxNode;
	
	public String toString(){
		return "The value:"+value + "  The NexNode value: "+(nextNode==null?"":nextNode.value) +"   The Max Node value:"+(maxNode==null?"":maxNode.value);
	}
	
}

public class MaxmimumStackValue<T> {
	
	private Node<T> headNode;
	private Node<T> maxNode;
	
	public static void main(String[] args) {
		MaxmimumStackValue<Integer> stackValue = new MaxmimumStackValue<>();
		stackValue.push(1);
		stackValue.push(10);
		stackValue.push(2);
		stackValue.push(7);
		stackValue.printNode();
		System.out.println("the head node value"+stackValue.maxNode.value);
		stackValue.pop();
		System.out.println("the head node value"+stackValue.maxNode.value);
		stackValue.printNode();
		stackValue.pop();
		System.out.println("the head node value"+stackValue.headNode.value);
		stackValue.printNode();
		stackValue.pop();
		System.out.println("the head node value"+stackValue.headNode.value);

	}
	
	public void push(T value){
		Node<T> newNode = new Node<T>();
		newNode.value = value;
		newNode.nextNode = headNode;
		if(headNode==null){
			maxNode = newNode;
			newNode.maxNode = newNode;	
		}
		
		headNode = newNode;
		if(((Comparable)maxNode.value).compareTo(newNode.value)<=0){
			maxNode=newNode;
			newNode.maxNode=newNode;
		}else{
			newNode.maxNode=maxNode;
		}
	}
	
	public T pop(){
		if(headNode == null){
			return null;
		}
		Node<T> tempNode = headNode;
		maxNode = headNode.maxNode;
		headNode = headNode.nextNode;
		System.out.println("The poped element:"+tempNode.value);
		return tempNode.value;
	}
	
	public void printNode(){
		Node<T> tempNode = headNode;
		while(tempNode!=null){
			System.out.println(tempNode);
			tempNode = tempNode.nextNode;
			
		}
	}

}
