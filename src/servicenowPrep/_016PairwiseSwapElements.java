package servicenowPrep;

public class _016PairwiseSwapElements {

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
		ln=pairwiseSwap(ln);
		while(ln!=null)
		{
			System.out.println(ln.value);ln=ln.next;
		}
	}

	private static ListNode pairwiseSwap(ListNode ln) {
		ListNode pointer=ln;
		while(pointer!=null)
		{
			if(pointer.next!=null)
			{
				int temp=pointer.next.value;
				pointer.next.value=pointer.value;
				pointer.value=temp;
			}
			else{
				break;
			}
			pointer=pointer.next.next;
		}
		return ln;
	}


}
