package eBayPrep;

public class _061RotateList {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);
		ln=rotateRight(ln, 2);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}

	private static ListNode rotateRight(ListNode ln, int count) {
		if(ln==null||ln.next==null)
			return ln;

		ListNode newPointer=ln;
		int length=findLength(newPointer);
		count=count%length;
		for (int j = 0; j < count; j++) {
			ln=rotateOnce(ln);
		}
		return ln;
	}

	private static int findLength(ListNode ln) {
		if(ln==null)
			return 0;
		return 1+findLength(ln.next);
	}

	private static ListNode rotateOnce(ListNode ln) {
		ListNode headPointer=ln;
		ListNode prev=null,curr=ln;
		while(ln!=null)
		{
			prev=ln;
			curr=ln.next;
			ln=ln.next;
			if(ln.next==null)
				break;
		}
		prev.next=null;
		curr.next=headPointer;
		return curr;
	}


}

