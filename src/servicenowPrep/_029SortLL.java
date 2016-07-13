package servicenowPrep;

public class _029SortLL {

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
        ln.next.next = new ListNode(0);
        ln.next.next.next = new ListNode(2);
        ln.next.next.next.next = new ListNode(1);
        ln.next.next.next.next.next = new ListNode(1);
        ln.next.next.next.next.next.next = new ListNode(2);
        ln.next.next.next.next.next.next.next = new ListNode(1);
        ln.next.next.next.next.next.next.next.next = new ListNode(2);
        ln=sortLL(ln);
        while(ln!=null)
        {
        	System.out.println(ln.value);ln=ln.next;
        }
	}
	private static ListNode sortLL(ListNode ln) {
		
		return null;
	}
	
}
