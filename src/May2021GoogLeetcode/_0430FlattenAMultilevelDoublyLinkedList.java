package May2021GoogLeetcode;

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
		dfs(head, list);
		Node prev = null;
		for (int i = 0; i < list.size(); i++) {
			Node curr = list.get(i);
			curr.prev = prev;
			curr.child = null;
			if (prev != null) {
				prev.next = curr;
			}

			prev = curr;
		}

		return list.get(0);
	}

	public void dfs(Node head, List<Node> list) {
		if (head == null)
			return;
		list.add(head);
		dfs(head.child, list);
		dfs(head.next, list);
	}

}
