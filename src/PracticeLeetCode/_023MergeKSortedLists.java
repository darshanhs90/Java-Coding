package PracticeLeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _023MergeKSortedLists {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int value) {
			this.val=value;
		}
	}a
	public static void main(String[] args) {

	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0)
			return null;
		ListNode output=new ListNode(-1);
		ListNode outputPtr=output;
		PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode a,ListNode b)
			{
				return a.val-b.val;
			}
		});
		for (int i = 0; i < lists.length; i++) {
			if(lists[i]!=null)
				queue.offer(lists[i]);
		}
		while(!queue.isEmpty())
		{
			ListNode ln=queue.poll();
			output.next=ln;
			output=output.next;
			if(ln.next!=null)
			{
				queue.offer(ln.next);
			}
		}
		return outputPtr.next;
	}
}

