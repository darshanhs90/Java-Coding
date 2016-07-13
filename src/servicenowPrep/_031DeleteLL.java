package servicenowPrep;

public class _031DeleteLL {

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
        ln=deleteLL(ln);
        
        while(ln!=null)
        {
        	System.out.println(ln.value);ln=ln.next;
        }
	}
	private static ListNode deleteLL(ListNode ln) {
		while(ln!=null)
		{
			ListNode temp=ln.next;
			ln=null;
			ln=temp;
		}
		return ln;
	}
	
}
