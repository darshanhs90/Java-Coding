package servicenowPrep;

public class _023RemoveDuplicates {
	
	static class ListNode{
		int value;
		public ListNode(int value) {
			this.value=value;
		}
		ListNode next;
		
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(11);
		ln.next=new ListNode(11);
		ln.next.next=new ListNode(11);
		ln.next.next.next=new ListNode(21);
		ln.next.next.next.next=new ListNode(43);
		ln.next.next.next.next.next=new ListNode(43);
		ln.next.next.next.next.next.next=new ListNode(60);
		ln=removeDuplicates(ln);
		System.out.println("****");
		while(ln!=null)
		{
			System.out.println(ln.value);
			ln=ln.next;
		}
	}
	private static ListNode removeDuplicates(ListNode ln) {
		ListNode pointer=ln;
		ListNode prev=null,curr=ln;
		while(curr!=null)
		{	
			if(prev==null ||curr.value!=prev.value)
			{
				prev=curr;
				curr=curr.next;
				System.out.println(prev.value);
				ln.next=prev;
				ln=ln.next;
			}
			else{
				curr=curr.next;
			}
		}
		
		
		
		return pointer;
	}
	

	

}
