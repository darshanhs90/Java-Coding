package servicenowPrep;

public class _011InsertInSortedWay {

	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(2);
		ln.next=new ListNode(5);
		ln.next.next=new ListNode(7);
		ln.next.next.next=new ListNode(10);
		ln.next.next.next.next=new ListNode(15);
		ln=(insertSorted(ln,9));
		while(ln!=null)
		{
			System.out.println(ln.value);
			ln=ln.next;
		}
	}

	private static ListNode insertSorted(ListNode ln, int i) {
		if(ln.value>i)
		{
			ListNode newHead=new ListNode(i);
			newHead.next=ln;
			return newHead;
		}
		else{
			ListNode pointer=ln;
			ListNode prev=null,curr=ln;
			while(pointer!=null && pointer.value<i)
			{
				prev=pointer;
				curr=pointer.next;
				pointer=pointer.next;
			}
			ListNode temp=new ListNode(i);
			prev.next=temp;
			temp.next=curr;
		}
		return ln;
	}

	


}
