package LeetcodeTemplate;

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
			Node randomVal = head.random != null ? head.random : null;
			System.out.println(head + "->" + randomVal);
			head = head.next;
		}
	}

	public static Node copyRandomList(Node head) {
		
	}

}
