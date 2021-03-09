package Feb2021Leetcode;

public class _0708InsertIntoASortedCircularLinkedList {
	public static void main(String[] args) {
	}

	static class Node {
		public int val;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _next) {
			val = _val;
			next = _next;
		}
	};

	public static Node insert(Node head, int insertVal) {

		if (head == null) {
			Node newNode = new Node(insertVal);
			newNode.next = newNode;
			return newNode;
		} else if (head.next == head) {
			Node newNode = new Node(insertVal);
			newNode.next = head;
			head.next = newNode;
			return head;
		}

		Node prev = head, curr = head.next;
		Node maxNode = head;
		int count = 0;
		while (curr != head && count < 2) {
			if (curr == head)
				count++;
			if (insertVal >= prev.val && insertVal <= curr.val) {
				Node newNode = new Node(insertVal);
				prev.next = newNode;
				newNode.next = curr;
				return head;
			}

			if (curr.val > maxNode.val) {
				maxNode = curr;
			}

			prev = curr;
			curr = curr.next;
		}

		Node newNode = new Node(insertVal);
		Node tail = maxNode;
		head = maxNode.next;
		tail.next = newNode;
		newNode.next = head;
		return head;
	}
}
