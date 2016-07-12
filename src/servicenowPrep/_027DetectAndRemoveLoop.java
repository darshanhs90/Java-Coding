package servicenowPrep;

public class _027DetectAndRemoveLoop {

	static class ListNode{
		int value;
		public ListNode(int value) {
			this.value=value;
		}
		ListNode next;

	}
	public static void main(String[] args) {
		ListNode ln = new ListNode(50);
        ln.next = new ListNode(20);
        ln.next.next = new ListNode(15);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(10);
        ln.next.next.next.next.next = ln.next.next;
        if(detectLoop(ln))
        	ln=removeLoop(ln);
        while(ln!=null)
        {
        	System.out.println(ln.value);ln=ln.next;
        }
	}
	private static ListNode removeLoop(ListNode ln) {
		ListNode fastPointer=ln.next.next;
		ListNode slowPointer=ln;
		ListNode prev=null;
		while(fastPointer!=null && fastPointer!=slowPointer)
		{
			fastPointer=fastPointer.next;
			fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
			prev=fastPointer;
		}
		prev.next=null;
		return ln;
	}
	private static boolean detectLoop(ListNode ln) {
		ListNode fastPointer=ln.next.next;
		ListNode slowPointer=ln;
		while(fastPointer!=null && fastPointer!=slowPointer)
		{
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
			else
				return false;
			slowPointer=slowPointer.next;
		}
		return true;
	}

}
