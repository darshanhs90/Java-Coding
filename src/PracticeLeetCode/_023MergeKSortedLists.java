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
	}
	public static void main(String[] args) {

	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0)
			return null;
		ListNode output=new ListNode(-1);
		ListNode outputPointer=output;

		PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});
		for(ListNode ln : lists)
		{
			if(ln!=null)
				queue.offer(ln);
		}
		while(!queue.isEmpty())
		{
			ListNode ln=queue.poll();
			if(ln.next!=null)
			{
				queue.offer(ln.next);
			}
			output.next=ln;
			output=output.next;
		}
		output.next=null;
		return outputPointer.next;
	}
}

