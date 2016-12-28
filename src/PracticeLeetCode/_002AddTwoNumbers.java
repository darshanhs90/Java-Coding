package PracticeLeetCode;


public class _002AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(8);
		//l1.next.next=new ListNode(3);
		ListNode l2=new ListNode(0);
		//l2.next=new ListNode(6);
		//l2.next.next=new ListNode(4);
		l1=addTwoNumbers(l1, l2);
		while(l1!=null){
			System.out.println(l1.val);
			l1=l1.next;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry=0;
		ListNode output=new ListNode(-1);
		ListNode outputPointer=output;
		while(l1!=null && l2!=null)
		{
			int val=l1.val+l2.val+carry;
			if(val>9)
				carry=1;
			else
				carry=0;
			output.next=new ListNode(val%10);
			output=output.next;	
			l1=l1.next;
			l2=l2.next;
		}
		if(l1!=null)
			while(l1!=null)
			{
				int val=l1.val+carry;
				if(val>9)
					carry=1;
				else
					carry=0;
				output.next=new ListNode(val%10);
				output=output.next;	
				l1=l1.next;
			}
		if(l2!=null)
			while(l2!=null)
			{
				int val=l2.val+carry;
				if(val>9)
					carry=1;
				else
					carry=0;
				output.next=new ListNode(val%10);
				output=output.next;	
				l2=l2.next;
			}
		if(carry==1){
			output.next=new ListNode(1);
			output=output.next;
		}
		return outputPointer.next;
	}



}
