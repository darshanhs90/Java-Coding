package servicenowPrep;

public class _028AddNosLL {

	static class ListNode{
		int value;
		public ListNode(int value) {
			this.value=value;
		}
		ListNode next;

	}
	public static void main(String[] args) {
		ListNode ln = new ListNode(7);
        ln.next = new ListNode(5);
        ln.next.next = new ListNode(9);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(6);
		ListNode ln1 = new ListNode(8);
        ln1.next = new ListNode(4);
        ln=addNos(ln,ln1);
        while(ln!=null)
        {
        	System.out.println(ln.value);ln=ln.next;
        }
	}
	private static ListNode addNos(ListNode ln, ListNode ln1) {
		int carry=0;
		while(ln!=null && ln1!=null)
		{
			
		}
		return null;
	}
	

}
