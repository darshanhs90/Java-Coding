package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0426ConvertBinarySearchTreeToSortedDoublyLinkedList {

	public static void main(String[] args) {
		Node node = new Node(4);
		node.left = new Node(2);
		node.right = new Node(5);
		node.left.left = new Node(1);
		node.left.right = new Node(3);

		node = treeToDoublyList(node);
		printNodes(node);

	}

	public static void printNodes(Node node) {
		if (node != null) {
			System.out.println(node.val);
			Integer leftVal = node.left != null ? node.left.val : null;
			Integer rightVal = node.right != null ? node.right.val : null;
			System.out.println("left" + leftVal);
			System.out.println("right" + rightVal);
			printNodes(node.right);
		}
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};

	public static Node treeToDoublyList(Node root) {
		if (root == null)
			return root;

		List<Node> list = new ArrayList<Node>();
		inOrder(root, list);

		for (int i = 0; i < list.size() - 1; i++) {
			Node prev = list.get(i);
			Node curr = list.get(i + 1);
			prev.right = curr;
			curr.left = prev;
		}
		Node startNode = list.get(0);
		Node lastNode = list.get(list.size() - 1);
		lastNode.right = startNode;
		startNode.left = lastNode;
		return startNode;
	}

	public static void inOrder(Node root, List<Node> list) {
		if (root == null)
			return;
		inOrder(root.left, list);
		list.add(root);
		inOrder(root.right, list);
	}

}
