package com.rajasekar.tree.course;

public class App {

	public static void main(String[] args) {
		
		BalancedTree<Integer> tree = new BalancedTree<>();
		
		tree.insert(1);
		tree.traverseInOrder();
		tree.insert(-2);
		tree.traverseInOrder();
		tree.insert(3);
		tree.traverseInOrder();
		tree.insert(2);
		tree.traverseInOrder();
		tree.insert(105);
		tree.traverseInOrder();
		tree.insert(102);
		tree.traverseInOrder();
		tree.insert(-33);
		tree.traverseInOrder();
		tree.insert(-3);
		tree.traverseInOrder();
		
		System.out.println(tree.getMax());
		System.out.println(tree.getMin());
		
		tree.traverseInOrder();
		
		System.out.println();
		tree.traverseInOrder();
		
		System.out.println();
		System.out.println(tree.getMin());
		
	}
}
