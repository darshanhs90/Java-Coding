package servicenowPrep;

public class _009getNthNode {

	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(10);
		ln.next.next=new ListNode(30);
		ln.next.next.next=new ListNode(14);
		ln=(getNode(ln,2));
		System.out.println(ln.value);
	}

	private static ListNode getNode(ListNode ln, int N) {
		while(N>0)
		{
			ln=ln.next;
			N--;
		}
		return ln;
	}

	



}
