package Mar2021Leetcode;

import java.util.HashMap;
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
		HashMap<Integer, Integer> map;
		Random rand;

		/**
		 * @param head The linked list's head. Note that the head is guaranteed to be
		 *             not null, so it contains at least one node.
		 */
		public Solution(ListNode head) {
			map = new HashMap<Integer, Integer>();
			rand = new Random();
			int count = 0;
			while (head != null) {
				map.put(count++, head.val);
				head = head.next;
			}
		}

		/** Returns a random node's value. */
		public int getRandom() {
			return map.get(rand.nextInt(map.size()));
		}
	}

}
