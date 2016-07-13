package servicenowPrep;

public class _030FindNthEnd {

	static class ListNode{
		int value;
		public ListNode(int value) {
			this.value=value;
		}
		ListNode next;

	}
	public static void main(String[] args) {
		ListNode ln = new ListNode(0);
        ln.next = new ListNode(1);
        ln.next.next = new ListNode(2);
        ln.next.next.next = new ListNode(3);
        ln.next.next.next.next = new ListNode(4);
        ln.next.next.next.next.next = new ListNode(5);
        ln.next.next.next.next.next.next = new ListNode(6);
        ln.next.next.next.next.next.next.next = new ListNode(7);
        ln.next.next.next.next.next.next.next.next = new ListNode(8);
        ln=getNthNode(ln,3);
        System.out.println(ln.value);
       /* while(ln!=null)
        {
        	System.out.println(ln.value);ln=ln.next;
        }*/
	}
	private static ListNode getNthNode(ListNode ln,int fromEnd) {
		ListNode startPointer=ln,endPointer=ln;
		while(fromEnd!=0)
		{
			endPointer=endPointer.next;
			fromEnd--;
		}
		while(endPointer!=null)
		{
			endPointer=endPointer.next;
			startPointer=startPointer.next;
		}
		return startPointer;
	}
	
}
