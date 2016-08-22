package com.rajasekar.tst;

public class TenarySearchTree <V extends Comparable<V>> {
	
	class Node<V extends Comparable<V>>{
		
		private Character key;
		private V value;
		private Node<V> middleNode;
		public Character getKey() {
			return key;
		}
		public void setKey(Character key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		public Node<V> getMiddleNode() {
			return middleNode;
		}
		public void setMiddleNode(Node<V> middleNode) {
			this.middleNode = middleNode;
		}
		public Node<V> getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node<V> leftNode) {
			this.leftNode = leftNode;
		}
		public Node<V> getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node<V> rightNode) {
			this.rightNode = rightNode;
		}
		private Node<V> leftNode;
		private Node<V> rightNode;
		
	}

	Node<V> rootNode;
	
	public TenarySearchTree(){
		
	}
	
	public void put(String key, V value){
		rootNode = put(rootNode,key,value,0);
	}
	
	public V get(String key){
		Node<V> node = get(rootNode,key,0);
		if(node == null ) return null;
		return node.getValue();
	}
	
	private Node<V> get(Node<V> node,String key , int index){
		Character ch;
		
		ch = key.charAt(index);
		
		
		
		if(Character.getNumericValue(ch)< Character.getNumericValue(node.getKey())){
			return get(node.getLeftNode(),key,index);
		}else if(Character.getNumericValue(ch) > Character.getNumericValue(node.getKey())){
			return get(node.getRightNode(),key,index);
		}
		else if(index < key.length()-1){	
			return get(node.middleNode,key,index+1);
		}else{
			return node;
		}
		
	}
	
	public Node<V> put(Node<V> node, String key, V value, int index){
		Character ch;
		
		ch = key.charAt(index);
		if(node == null){
			node = new Node<V>();
			node.key = ch;
			
		}
		
		
		if(Character.getNumericValue(ch)< Character.getNumericValue(node.getKey())){
			node.setLeftNode(put(node.getLeftNode(),key,value,index));
		}else if(Character.getNumericValue(ch) > Character.getNumericValue(node.getKey())){
			node.setRightNode(put(node.getRightNode(),key,value,index));
		}else if(index < key.length()-1){
			node.setMiddleNode(put(node.getMiddleNode(),key,value,index+1));
		}else{
			node.setValue(value);
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		TenarySearchTree<Integer> tstInteger = new TenarySearchTree<>();
		tstInteger.put("rajasekar", 35);
		tstInteger.put("ramkumar", 34);
		System.out.println(tstInteger.get("rajasekar"));
	}

}
