package PracticeLeetCode;

public class _024SwapNodesInPairs {
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
		ListNode fakeHead=new ListNode(-1);
		fakeHead.next=head;
		ListNode pointer=fakeHead;
		while(pointer!=null)
		{
			ListNode firstNode=pointer.next;
			ListNode nextNode=null;
			if(firstNode!=null && firstNode.next!=null){
				nextNode=firstNode.next;
				pointer.next=nextNode;
				ListNode temp=nextNode.next;
				nextNode.next=firstNode;
				firstNode.next=temp;
				pointer=pointer.next.next;
			}
			else{
				pointer=pointer.next;
			}
		}
		return fakeHead.next;
	}


}

