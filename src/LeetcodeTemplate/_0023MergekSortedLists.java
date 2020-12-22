package LeetcodeTemplate;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0023MergekSortedLists {
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

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ln1.next = new ListNode(4);
		ln1.next = new ListNode(6);
		ListNode ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next = new ListNode(4);
		ListNode ln3 = new ListNode(2);
		ln3.next = new ListNode(6);
		ln1 = mergeKLists(new ListNode[] { ln1, ln2, ln3 });
		printNodes(ln1);
		System.out.println();
	}

	
}
