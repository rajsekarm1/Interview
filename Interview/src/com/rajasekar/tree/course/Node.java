package com.rajasekar.tree.course;

public class Node <T extends Comparable<T>>{
	private T data;
	private Node leftChild;
	private int balance;
	
	public Node(T data, Node<T> parentNode){
		this.data = data;
		this.parentNode = parentNode;
		this.leftChild = null;
		this.rightChild = null;
		
	}
	
	public Node<T> insert(T newData, Node<T> parentNode){	
		
		if( newData.compareTo(this.data) < 0 ){
			if( this.leftChild == null ){
				this.leftChild = new Node<>(newData,parentNode);
			}else{
				this.leftChild.insert(newData, this);
			}
		}else{
			if( this.rightChild == null ){
				this.rightChild = new Node<>(newData,parentNode);
			}else{
				this.rightChild.insert(newData, this);
			}
		}
		
		return parentNode;
	}
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	private Node rightChild;
	private Node parentNode;
	
	public String toString(){
		if(data!=null)
			return data.toString();
		return null;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
