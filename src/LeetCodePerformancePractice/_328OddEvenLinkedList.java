package LeetCodePerformancePractice;

public class _328OddEvenLinkedList {
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
		ln.next.next.next.next.next=new ListNode(6);
		ln.next.next.next.next.next.next=new ListNode(7);
		ln.next.next.next.next.next.next.next=new ListNode(8);

		ln=oddEvenList(ln);
		while(ln!=null)
		{
			System.out.println(ln.val);ln=ln.next;
		}
	}
	public static ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode output=head;
		ListNode t1=head;
		ListNode t2=head.next;
		ListNode connector=t2;
		while(t1!=null &&t2!=null)
		{
			if(t2.next==null)
				break;
			t1.next=t1.next.next;
			t1=t1.next;
			if(t2.next!=null)
				t2.next=t2.next.next;
			t2=t2.next;
		}
		t1.next=connector;
		return head;
	}
}
