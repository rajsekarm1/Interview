package com.rajasekar.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {
	
	
	static class Node{
		
		public Node(int value){
			super();
			this.value = value;
		}
		public Node(int value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
		int value;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		
		Node rootNode = new Node(50);
		Node node45 = new Node(45);
		Node node55 = new Node(55);
		rootNode.left = node45;
		rootNode.right = node55;
		Node node42 = new Node(42);
		Node node46 = new Node(46);
		node45.left = node42;
		node45.right = node46;
		Node node54 = new Node(54);
		Node node60 = new Node(60);
		Node node58 = new Node(58);
		Node node57 = new Node(57);
		node55.left = node54;
		node55.right = node60;
		node60.left = node58;
		node58.left = node57;
		Tree tree = new Tree();
		System.out.print("In Order Traverse:   ");
		tree.inOrderTraverse(rootNode);
		
		System.out.print("\nPre Order Traverse:  ");
		tree.preOrderTraverse(rootNode);
		
		System.out.print("\n Post Order Traverse:  ");
		tree.postOrderTraverse(rootNode);
		List<Node> listTree = new LinkedList<>();
		listTree.add(rootNode);
		System.out.print("\n Tree Width Traverse:  ");
		tree.treeWidthTraverse(listTree);
	}
	
	private void treeWidthTraverse(List<Node> listTree) {
		
		while(!listTree.isEmpty()){
			Node node = listTree.remove(0);
			System.out.print(node.value+"   ,   ");
			if(node.left!=null)
				listTree.add(node.left);
			if(node.right!=null)
				listTree.add(node.right);
		}
		
		
	}

	public void inOrderTraverse(Node rootNode){		
		if(rootNode==null){
			return;
		}
		inOrderTraverse(rootNode.left);
		System.out.print(rootNode.value+"   ,   ");
		inOrderTraverse(rootNode.right);		
	}
	
	public void preOrderTraverse(Node rootNode){
		if(rootNode==null){
			return;
		}
		System.out.print(rootNode.value+ "    ,  ");
		preOrderTraverse(rootNode.left);
		preOrderTraverse(rootNode.right);
	}
	
	public void postOrderTraverse(Node rootNode){
		if(rootNode==null){
			return;
		}
		postOrderTraverse(rootNode.left);
		postOrderTraverse(rootNode.right);
		System.out.print(rootNode.value+ "    ,  ");
	}

}
