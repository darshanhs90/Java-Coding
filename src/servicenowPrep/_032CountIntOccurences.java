package servicenowPrep;

public class _032CountIntOccurences {

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
		ln.next.next.next.next.next = new ListNode(2);
		ln.next.next.next.next.next.next = new ListNode(6);
		ln.next.next.next.next.next.next.next = new ListNode(2);
		ln.next.next.next.next.next.next.next.next = new ListNode(8);
		System.out.println(getCount(ln,2));

	}
	private static int getCount(ListNode ln,int number) {
		int count=0;
		while(ln!=null)
		{	
			count+=(ln.value==number)?1:0;
			ln=ln.next;
		}
		return count;
	}

}
