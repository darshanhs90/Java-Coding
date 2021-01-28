package Dec2020Leetcode;

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
		if (head == null)
			return head;
		Queue<Node> q = new LinkedList<Node>();
		dfs(head, q);

		Node prev = q.poll();
		prev.child = null;
		Node prevPtr = prev;
		while (!q.isEmpty()) {
			Node curr = q.poll();
			prev.next = curr;
			prev.child = null;
			curr.prev = prev;
			curr.child = null;
			prev = curr;
		}
		return prevPtr;
	}

	public void dfs(Node head, Queue<Node> q) {
		if (head != null) {
			q.offer(head);
			if (head.child != null) {
				dfs(head.child, q);
			}
			dfs(head.next, q);
		}
	}

}
