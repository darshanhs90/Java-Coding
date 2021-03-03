package FacebookPrep;

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
		Node startNodePtr = head;

		if (head == null) {
			Node newNode = new Node(insertVal);
			newNode.next = newNode;
			return newNode;
		} else if (head.next == head) {

			if (head.val > insertVal) {
				Node newNode = new Node(insertVal);
				newNode.next = head;
				head.next = newNode;
				return newNode;
			} else {
				Node newNode = new Node(insertVal);
				head.next = newNode;
				newNode.next = head;
				return head;
			}
		} else {
			Node prev = head;
			Node curr = head.next;

			while (curr != startNodePtr) {
				if (prev.val < insertVal && insertVal < curr.val) {

					Node newNode = new Node(insertVal);
					prev.next = newNode;
					newNode.next = curr;
					if (curr == startNodePtr) {
						return newNode;
					}
					return startNodePtr;
				}
				Node temp = curr;
				prev = curr;
				curr = temp.next;
			}

			Node newNode = new Node(insertVal);
			prev.next = newNode;
			newNode.next = curr;

			return startNodePtr;
		}
	}
}
