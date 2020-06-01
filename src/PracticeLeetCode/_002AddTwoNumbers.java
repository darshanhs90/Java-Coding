package PracticeLeetCode;


public class _002AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	public static void main(String[] args) {
		ListNode ln1 =new ListNode(2);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(3);
		ListNode ln2 =new ListNode(5);
		ln2.next = new ListNode(6);
		ln2.next.next = new ListNode(4);
		ListNode ln = addTwoNumbers(ln1, ln2);
		while(ln!= null)
		{
			System.out.println(ln.val);
			ln = ln.next;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode op = new ListNode(-1);
		ListNode ptr = op;
		while(l1 != null || l2 != null)
		{
			int leftVal =0;
			if(l1 != null)
			{
				leftVal = l1.val;
				l1 = l1.next;
			}
			int rightVal = 0;
			if(l2 != null)
			{
				rightVal = l2.val;
				l2 = l2.next;
			}
			int val = leftVal + rightVal + carry;
			if(val > 9) {
				carry = 1;
				val = val - 10;
			} else {
				carry = 0;
			}
			op.next = new ListNode(val);
			op = op.next;
		}
		if(carry != 0)
		{
			op.next = new ListNode(carry);
			op = op.next;
		}
		
		return ptr.next;
	}



}
