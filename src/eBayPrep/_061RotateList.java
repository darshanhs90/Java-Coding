package LeetCodePractice;

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
		ln=rotateRight(ln, 5);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
		ListNode headPointer=head;
		if(head==null||head.next==null)
			return head;
		
		int length=findLength(head);
		k=k%length;
		for (int i = 0; i < k; i++) {
			headPointer=head;
			headPointer=rotateListToRight(headPointer);
		}
		return headPointer;

	}

	private static int findLength(ListNode head) {
		int count=0;
		while(head!=null)
		{
			count++;
			head=head.next;
		}
		return count;
	}

	private static ListNode rotateListToRight(ListNode headPointer) {
		ListNode pointer=headPointer;
		int temp=Integer.MIN_VALUE;;//1->2->3->4->5
		while(headPointer!=null)
		{
			if(headPointer.next!=null)
			{
				if(temp==Integer.MIN_VALUE){
					temp=headPointer.next.val;
					headPointer.next.val=headPointer.val;
				}
				else{
					int tempPrev=temp;
					temp=headPointer.next.val;
					headPointer.next.val=tempPrev;
				}
				headPointer=headPointer.next;
			}
			else{
				//temp=headPointer.val;
				headPointer=null;
			}

		}
		pointer.val=temp;
		return pointer;

	}
}

