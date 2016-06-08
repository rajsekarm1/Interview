
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
		tree.inOrderTraverse(rootNode);
		
	}
	
	public void inOrderTraverse(Node rootNode){
		
		if(rootNode==null){
			return;
		}
		inOrderTraverse(rootNode.left);
		System.out.println(rootNode.value);
		inOrderTraverse(rootNode.right);
		
	}

}
