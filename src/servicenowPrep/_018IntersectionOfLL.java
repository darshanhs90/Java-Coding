package servicenowPrep;

import java.util.HashSet;
import java.util.Set;

public class _018IntersectionOfLL {

	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(6);
		ListNode ln1=new ListNode(2);
		ln1.next=new ListNode(4);
		ln1.next.next=new ListNode(6);
		ln1.next.next.next=new ListNode(8);
		ln=intersection(ln,ln1);
		while(ln!=null)
		{
			System.out.println(ln.value);ln=ln.next;
		}
	}

	private static ListNode intersection(ListNode ln, ListNode ln1) {
		ListNode outputPointer=new ListNode(-1);
		ListNode output=outputPointer;

		Set<Integer> set=new HashSet<>();
		while(ln!=null)
		{
			set.add(ln.value);
			ln=ln.next;
		}
		while(ln1!=null)
		{
			if(set.contains(ln1.value))
			{
				output.next=new ListNode(ln1.value);
				output=output.next;
			}
			ln1=ln1.next;
		}
		return outputPointer.next;
	}



}
