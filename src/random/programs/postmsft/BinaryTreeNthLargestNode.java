package random.programs.postmsft;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.logging.Logger;

public class BinaryTreeNthLargestNode {

	private static class Node {
		Node left;
		Node right;
		int val;

		public int val() {
			return val;
		}
	}

	public static void main(String[] args) {
		Logger log = Logger.getLogger(BinaryTreeNthLargestNode.class.getName());
		Optional.ofNullable(dfsTraverseTree(buildTree(), new ArrayDeque<>(), 1, 0)).map(Node::val).map(String::valueOf)
				.ifPresent(log::info);
		Optional.ofNullable(dfsTraverseTree(buildTree1(), new ArrayDeque<>(), 3, 0)).map(Node::val).map(String::valueOf)
				.ifPresent(log::info);
		Optional.ofNullable(dfsTraverseTree(buildTree2(), new ArrayDeque<>(), 6, 0)).map(Node::val).map(String::valueOf)
				.ifPresent(log::info);
	}

	private static Node dfsTraverseTree(Node root, Deque<Node> stack, int i, int c) {
		while (root != null) {
			stack.push(root);
			root = root.right;
		}
		while (!stack.isEmpty()) {
			Node n = stack.pop();
			c++;
			if (c == i)
				return n;
			if (n.left != null) {
				return dfsTraverseTree(n.left, stack, i, c);
			}
		}
		return null;
	}

	private static Node buildTree() {
		Node root = new Node();
		root.val = 5;
		root.left = new Node();
		root.left.val = 3;
		root.left.right = new Node();
		root.left.right.val = 4;
		root.left.left = new Node();
		root.left.left.val = 2;
		root.right = new Node();
		root.right.val = 10;
		root.right.right = new Node();
		root.right.right.val = 13;
		root.right.left = new Node();
		root.right.left.val = 8;
		return root;
	}

	private static Node buildTree1() {
		Node root = new Node();
		root.val = 5;
		root.left = new Node();
		root.left.val = 3;
		root.left.right = new Node();
		root.left.right.val = 4;
		root.left.left = new Node();
		root.left.left.val = 2;
		return root;
	}

	private static Node buildTree2() {
		Node root = new Node();
		root.val = 5;
		root.left = new Node();
		root.left.val = 3;
		root.left.right = new Node();
		root.left.right.val = 4;
		root.left.left = new Node();
		root.left.left.val = 2;
		root.right = new Node();
		root.right.val = 10;
		root.right.left = new Node();
		root.right.left.val = 8;
		return root;
	}
}
