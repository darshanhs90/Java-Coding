package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0430FlattenAMultilevelDoublyLinkedList {

	public static void main(String[] args) {

	}

	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	};

	public Node flatten(Node head) {
		if (head == null)
			return head;

		List<Node> list = new ArrayList<Node>();

		flatten(head, list);
		Node prev = null;
		for (Node node : list) {
			if (prev != null)
				prev.next = node;
			node.child = null;
			node.prev = prev;
			prev = node;
		}

		return head;
	}

	public void flatten(Node head, List<Node> list) {
		if (head == null)
			return;

		list.add(head);
		flatten(head.child, list);
		flatten(head.next, list);
	}

}
