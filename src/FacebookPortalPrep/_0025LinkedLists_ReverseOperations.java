package FacebookPortalPrep;

public class _0025LinkedLists_ReverseOperations {

	public static void main(String[] args) {

	}

	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	// Add any helper functions you may need here

	public static Node reverse(Node head) {
		// Write your code here
		Node newHead = new Node(0);
		Node newHeadPtr = newHead;
		Node prev = null;
		while (head != null) {
			if (head.data % 2 == 0) {
				Node pointerToHead = head;
				Node prevNode = head;
				while (head != null && head.data % 2 == 0) {
					prevNode = head;
					head = head.next;
				}

				Node next = prevNode.next;
				prevNode.next = null;

				Node reverseNode = reverseLL(pointerToHead);
				
				if(prev == null)
					newHead.next = reverseNode;
				else {
					prev.next = reverseNode;
				}
				while (reverseNode != null && reverseNode.next != null) {
					reverseNode = reverseNode.next;
				}

				reverseNode.next = next;
				prev = reverseNode;
				head = reverseNode.next;
			} else {
				newHead.next = head;
				prev = head;
				newHead = newHead.next;
				head = head.next;
			}
		}
		return newHeadPtr.next;

	}

	public static Node reverseLL(Node head) {
		// Write your code here
		if (head == null || head.next == null)
			return head;
		Node nextNode = head.next;
		Node reverseNode = reverseLL(head.next);
		nextNode.next = head;
		head.next = null;
		return reverseNode;
	}
}
