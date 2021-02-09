package Jan2021Leetcode;

import java.util.LinkedList;
import java.util.Queue;

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
		Queue<Node> q = new LinkedList<Node>();
		dfs(head, q);

		Node prev = null;
		while (!q.isEmpty()) {
			Node curr = q.poll();
			curr.child = null;
			if (prev != null) {
				prev.next = curr;
			}

			curr.prev = prev;
			prev = curr;
		}

		return head;
	}

	public void dfs(Node head, Queue<Node> q) {
		if (head == null)
			return;
		q.offer(head);
		if (head.child != null) {
			dfs(head.child, q);
		}
		if (head.next != null) {
			dfs(head.next, q);
		}
	}

}
