package Nov2020Leetcode;

import java.util.HashMap;

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
			int randomval = head.random != null ? head.random.val : -1;
			System.out.println(head.val + "<->" + randomval + "---->");
			System.out.println(head + "<->" + head.random + "---->");
			head = head.next;
		}
		System.out.println();
	}

	public static Node copyRandomList(Node head) {
		HashMap<Node, Node> nodeMap = new HashMap<Node, Node>();
		Node dummy = new Node(-1);
		Node dummyPtr = dummy;
		Node headCopy = head;
		while (head != null) {
			Node newNode = new Node(head.val);
			nodeMap.put(head, newNode);
			head = head.next;
			dummy.next = newNode;
			dummy = dummy.next;
		}

		head = headCopy;
		while (head != null) {
			Node newNode = nodeMap.get(head);
			if (head.random != null) {
				newNode.random = nodeMap.get(head.random);
			}
			head = head.next;
		}
		return dummyPtr.next;
	}
}
