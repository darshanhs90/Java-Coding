package April2021PrepLeetcode;

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
			curr.child = null;
			if (prev != null) {
				prev.next = curr;
			}

			curr.prev = prev;
			prev = curr;
		}
		return head;
	}

	public void dfs(Node head, List<Node> nodes) {
		if (head == null)
			return;
		nodes.add(head);
		dfs(head.child, nodes);
		dfs(head.next, nodes);
	}

}
