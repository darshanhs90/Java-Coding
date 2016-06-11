package LeetCodePractice;

public class _023SwapNodesInPairs {
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
		ln=swapPairs(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode headPointer =head;
		ListNode pointer=head;
		while(pointer!=null){
			if(pointer.next==null)
				break;
			ListNode pointer1=pointer;
			ListNode pointer2=pointer.next;
			int temp=pointer1.val;
			pointer1.val=pointer2.val;
			pointer2.val=temp;
			pointer=pointer.next.next;
		}
		return headPointer;
	}
}
