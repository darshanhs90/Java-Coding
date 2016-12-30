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
		PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});
		ListNode outputNode=new ListNode(-1);
		ListNode outputPointer=outputNode;
		for (int i = 0; i < lists.length; i++) {
			if(lists[i]!=null)
				queue.add(lists[i]);
		}

		while(!queue.isEmpty()){
			ListNode ln=queue.poll();
			outputNode.next=new ListNode(ln.val);
			outputNode=outputNode.next;
			if(ln.next!=null)
			{
				queue.add(ln.next);
			}			
		}
		return outputPointer.next;	
	}
}

