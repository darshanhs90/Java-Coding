package servicenowPrep;

public class _007SearchAnElementInALinkedList {

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
		System.out.println(searchElementRecursive(ln,5));
		System.out.println(searchElementRecursive(ln,-1));
		
	}

	private static boolean searchElement(ListNode ln, int i) {
		while(ln!=null)
		{
			if(ln.value==i)
				return true;
			ln=ln.next;
		}
		return false;
	}
	
	private static boolean searchElementRecursive(ListNode ln, int i) {
		if(ln==null)
			return false;
		if(ln.value==i)
			return true;
		return searchElement(ln.next, i);
	}
	


}
