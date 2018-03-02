package algorithms;

import java.util.SortedMap;

public class BinarySearchTree {

	public static void main(String[] args) {

		Node rootNode = null;
		BinarySearchTree bst = new BinarySearchTree();
		rootNode = bst.insertNode(rootNode, 2, "R");
		bst.insertNode(rootNode, 1, "A");
		bst.insertNode(rootNode, 4, "Y");
		bst.insertNode(rootNode, 3, "A");
		bst.insertNode(rootNode, 2, "J");
		bst.insertNode(rootNode, 6, "U");
		bst.insertNode(rootNode, 7, "M");
		bst.insertNode(rootNode, 5, "K");
		bst.insertNode(rootNode, 9, "R");
		bst.insertNode(rootNode, 8, "A");
		bst.printTree(rootNode);

		bst.getNodeValue(rootNode, 7);

	}

	private void getNodeValue(Node rootNode, int i) {
		
	}

	private void printTree(Node rootNode) {
		if (rootNode != null && rootNode.key != 0) {
			printTree(rootNode.leftNode);
			System.out.println(rootNode.key + ":" + rootNode.value);
			printTree(rootNode.rightNode);
		}
	}

	public Node insertNode(Node node, int key, String value) {
		if (node == null) {
			node = new Node(null, null, key, value);
		} else if (key == node.key) {
			node.value = value;
		} else if (key < node.key) {
			node.leftNode = insertNode(node.leftNode, key, value);
		} else if (key > node.key) {
			node.rightNode = insertNode(node.rightNode, key, value);
		}
		return node;
	}

	class Node {

		Node leftNode;
		Node rightNode;
		int key;
		String value;

		public Node(Node leftNode, Node rightNode, int key, String value) {
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.key = key;
			this.value = value;
		}
	}

}