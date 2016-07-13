package servicenowPrep;

public class _010FindMiddleLL {

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
		ln.next.next.next.next=new ListNode(5);
		ln.next.next.next.next.next=new ListNode(6);
		ln=(findMiddle(ln));
		System.out.println(ln.value);
	}

	private static ListNode findMiddle(ListNode ln) {
		ListNode fastPointer=ln;
		ListNode slowPointer=null;
		while(fastPointer!=null)
		{
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
			slowPointer=slowPointer!=null?slowPointer.next:ln.next;
		}
		return slowPointer;
	}

	


}
