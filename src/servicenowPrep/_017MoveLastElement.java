package servicenowPrep;

public class _017MoveLastElement {

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
		ln=swapLast(ln);
		while(ln!=null)
		{
			System.out.println(ln.value);ln=ln.next;
		}
	}

	private static ListNode swapLast(ListNode ln) {
		ListNode temp=ln;
		ListNode prev=null,curr=ln;
		while(ln!=null&& ln.next!=null)
		{
			prev=ln;
			curr=ln.next;
			ln=ln.next;
		}
		prev.next=null;
		curr.next=temp;
		return curr;
	}




}
