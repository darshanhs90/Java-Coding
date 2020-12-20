package Nov2020_UberPrep;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _008MergeKSortedLists {

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
		// [[1,4,5],[1,3,4],[2,6]]
		ListNode ln1 = new ListNode(1);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(5);

		ListNode ln2 = new ListNode(1);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);

		ListNode ln3 = new ListNode(2);
		ln3.next = new ListNode(6);

		ln1 = mergeKLists(new ListNode[] { ln1, ln2, ln3 });
		printNodes(ln1);

		ln1 = mergeKLists(new ListNode[] {});
		printNodes(ln1);

		ln1 = mergeKLists(new ListNode[] { null });
		printNodes(ln1);
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode output = new ListNode();
		ListNode outputPtr = output;

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});

		for (ListNode ln : lists) {
			if (ln != null)
				pq.offer(ln);
		}

		while (!pq.isEmpty()) {
			ListNode ln = pq.poll();
			System.out.println(ln.val);
			output.next = new ListNode(ln.val);
			output = output.next;
			if (ln.next != null) {
				pq.offer(ln.next);
			}
		}

		return outputPtr.next;
	}

	public static void printNodes(ListNode ln) {
		while (ln != null) {
			System.out.print(ln.val + "->");
			ln = ln.next;
		}
		System.out.println();
	}

}
