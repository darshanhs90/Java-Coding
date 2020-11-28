package Nov2020_FBPrep;

import java.util.HashMap;

public class _025CopyListWithRandomPointer {
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
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		node1.random = null;
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;

		printNodes(node1);
		node1 = copyRandomList(node1);
		printNodes(node1);
	}

	public static void printNodes(Node ln) {
		while (ln != null) {
			System.out.println(ln + "<->" + ln.next + "<->" + ln.random);
			ln = ln.next;
		}
		System.out.println("************************");
	}

	public static Node copyRandomList(Node head) {
		HashMap<Node, Node> nodeMap = new HashMap<Node, Node>();
		nodeMap.put(null, null);
		Node headPtr = head;
		Node output = new Node(-1);
		Node outputPtr = output;
		while (head != null) {
			Node newNode = new Node(head.val);
			nodeMap.put(head, newNode);
			head = head.next;
			output.next = newNode;
			output = output.next;
		}

		head = headPtr;
		while (head != null) {
			Node n = nodeMap.get(head);
			n.next = nodeMap.get(head.next);
			n.random = nodeMap.get(head.random);
			head = head.next;
		}

		return outputPtr.next;
	}

}
