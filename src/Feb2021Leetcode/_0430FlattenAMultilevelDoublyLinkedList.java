package Feb2021Leetcode;

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
		populateList(head, list);
		Node headNode = list.get(0);
		Node prev = headNode;

		for (int i = 1; i < list.size(); i++) {
			Node curr = list.get(i);
            curr.child = null;
			prev.next = curr;
			curr.prev = prev;
			prev.child = null;
			prev = curr;
		}
		return headNode;
	}

	public void populateList(Node head, List<Node> list) {
		if (head == null)
			return;
		list.add(head);
		if (head.child != null) {
			populateList(head.child, list);
		}
		populateList(head.next, list);
	}

}
