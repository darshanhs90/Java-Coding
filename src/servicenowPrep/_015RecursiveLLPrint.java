package servicenowPrep;

public class _015RecursiveLLPrint {

	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(3);
		ln.next=new ListNode(6);
		ln.next.next=new ListNode(9);
		ln.next.next.next=new ListNode(15);
		ln.next.next.next.next=new ListNode(30);
		recursivePrint(ln);
	}

	private static void recursivePrint(ListNode ln) {
		if(ln==null)
			return;
		recursivePrint(ln.next);
		System.out.println(ln.value);
	}

	


}
