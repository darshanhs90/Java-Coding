package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;
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
		
	}

}
