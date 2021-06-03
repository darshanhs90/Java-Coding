package May2021GoogLeetcode;

import java.util.HashMap;
import java.util.Map;

public class _0138CopyListWithRandomPointer {
	static public class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(13);
		Node n3 = new Node(11);
		Node n4 = new Node(10);
		Node n5 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		n1.random = null;
		n2.random = n1;
		n3.random = n5;
		n4.random = n3;
		n5.random = n1;
		printNodes(n1);
		n1 = copyRandomList(n1);
		printNodes(n1);
	}

	public static void printNodes(Node head) {
		while (head != null) {
			Node randomVal = head.random != null ? head.random : null;
			System.out.println(head + "->" + randomVal);
			head = head.next;
		}
	}

	public static Node copyRandomList(Node node) {
		if (node == null)
			return node;
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		populateNode(node, map);
		map.put(null, null);
		populatePointers(map);
		return map.get(node);
	}

	public static void populatePointers(HashMap<Node, Node> map) {
		for (Map.Entry<Node, Node> entry : map.entrySet()) {
			if (entry.getKey() == null)
				continue;
			Node oldNode = entry.getKey();
			Node newNode = entry.getValue();
			newNode.next = map.get(oldNode.next);
			newNode.random = map.get(oldNode.random);
		}
	}

	public static void populateNode(Node node, HashMap<Node, Node> map) {
		if (node == null)
			return;
		Node newNode = new Node(node.val);
		map.put(node, newNode);
		populateNode(node.next, map);
	}

}
