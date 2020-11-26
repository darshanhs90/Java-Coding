package Nov2020Leetcode;

import java.util.Random;

public class _0382LinkedListRandomNode {

	public static void main(String[] args) {
		// Init a singly linked list [1,2,3].
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		Solution solution = new Solution(head);

		// getRandom() should return either 1, 2, or 3 randomly. Each element should
		// have equal probability of returning.
		System.out.println(solution.getRandom());
		System.out.println(solution.getRandom());
		System.out.println(solution.getRandom());

	}

	static public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	static class Solution {
		int length = 0;
		ListNode head;

		/**
		 * @param head The linked list's head. Note that the head is guaranteed to be
		 *             not null, so it contains at least one node.
		 */
		public Solution(ListNode head) {
			this.head = head;
			this.length = getLength(head);
		}

		/** Returns a random node's value. */
		public int getRandom() {
			Random r = new Random();
			int randomNode = r.nextInt(length);

			ListNode headPtr = head;
			while (randomNode > 0) {
				headPtr = headPtr.next;
				randomNode--;
			}
			return headPtr.val;
		}

		/** Returns a random node's value. */
		public int getLength(ListNode head) {
			if (head == null)
				return 0;
			return 1 + getLength(head.next);
		}
	}

}
