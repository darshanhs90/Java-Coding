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

		Node headPtr = head;
		Node prev = head;
		Node curr = head.next;
		int count = 0;
		Node maxNode = head;
		while (count < 2) {
			if (curr == headPtr)
				count++;

			if (insertVal >= prev.val && insertVal <= curr.val) {

				Node newNode = new Node(insertVal);
				prev.next = newNode;
				newNode.next = curr;
				return headPtr;
			}

			if (curr.val >= maxNode.val) {
				maxNode = curr;
			}

			prev = curr;
			curr = curr.next;
		}

		Node next = maxNode.next;
		Node newNode = new Node(insertVal);
		maxNode.next = newNode;
		newNode.next = next;

		return headPtr;
	}
}
