package careerCup;

/*
 * Link: http://www.careercup.com/question?id=310691
 * Implement merge sort of linked list
 */
public class _29googleCareerCup {
	public static void main(String[] args) {

		ListNode ln=new ListNode(3);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(4);
		ln.next.next.next=new ListNode(1);
		mergeSort(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);
			ln=ln.next;
		}
	}

	static ListNode a,b;
	private static void mergeSort(ListNode ln) {
		if ((ln == null) || (ln.next == null))
		{
			return;
		}

		split(ln,a,b);
		mergeSort(a);
		mergeSort(b);
		ln=sortedMerge(a,b);
	}


	private static ListNode sortedMerge(ListNode a, ListNode b) {
		if(a==null)
			return b;
		else if(b==null)
			return a;
		ListNode result=null;
		if(a.val<=b.val)
		{
			result=a;
			result.next=sortedMerge(a.next, b);
		}
		else
		{
			result=b;
			result.next=sortedMerge(a, b.next);	
		}
		return result;
	}


	private static void split(ListNode ln, ListNode a, ListNode b) {
		if(ln==null)
		{
			a=ln;
			b=null;
		}
		ListNode slowPointer=ln;
		ListNode fastPointer=ln;
		while(fastPointer!=null)
		{
			fastPointer=fastPointer.next;
			if(fastPointer==null)
				break;
			fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
		}
		a=ln;
		b=slowPointer!=null?slowPointer.next:null;
		if(slowPointer!=null)
			slowPointer.next=null;
	}


	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val=val;
		}
	}

}
