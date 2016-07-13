package servicenowPrep;

public class _021IdenticalLL {

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

		ListNode ln1=new ListNode(1);
		ln1.next=new ListNode(2);
		//ln1.next.next=new ListNode(3);

		System.out.println(isIdentical(ln,ln1));

	}

	private static boolean isIdentical(ListNode ln, ListNode ln1) {
		if(ln==null && ln1==null)
			return true;
		if(ln==null || ln1==null)
			return false;
		return ln.value==ln1.value && isIdentical(ln.next, ln1.next);
	}



}
