package servicenowPrep;

public class _006FindLengthOfLL {

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
		System.out.println(findLengthRecursive(ln));
	}

	private static int findLength(ListNode ln) {
		int count=0;
		while(ln!=null)
		{
			ln=ln.next;
			count+=1;
		}
		return count;
	}

	private static int findLengthRecursive(ListNode ln) {
		if(ln==null)
			return 0;
		return 1+findLength(ln.next);
	}


}
