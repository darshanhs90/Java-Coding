package Feb2021Leetcode;

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

		Node head = list.get(0);
		Node tail = list.get(list.size() - 1);
		Node prev = head;
		for (int i = 1; i < list.size(); i++) {
			Node curr = list.get(i);
			prev.right = curr;
			curr.left = prev;
			prev = curr;
		}

		tail.right = head;
		head.left = tail;
		return head;
	}

	public static void inOrder(Node root, List<Node> list) {
		if (root == null)
			return;
		inOrder(root.left, list);
		list.add(root);
		inOrder(root.right, list);
	}
}
