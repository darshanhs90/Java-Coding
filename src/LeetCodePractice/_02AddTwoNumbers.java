package LeetCodePractice;

public class _02AddTwoNumbers {
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
		if(l1==null||l2==null)
			return l1==null?l2:l1;
		ListNode output=new ListNode(-1);
		ListNode pointer=output;
		int carry=0;
		while(l1!=null && l2!=null)
		{
			int value=l1.val+l2.val+carry;
			if(value>9)
			{
				carry=1;
				value=value%10;
			}
			else
				carry=0;
			pointer.next=new ListNode(value);
			l1=l1.next;
			l2=l2.next;
			pointer=pointer.next;
		}

		if(l1!=null)
		{
			while(l1!=null)
			{
				int value=l1.val+carry;
				if(value>9)
				{
					carry=1;
					value=value%10;
				}
				else
					carry=0;
				pointer.next=new ListNode(value);
				l1=l1.next;
				pointer=pointer.next;
			}
		}else{
			while(l2!=null)
			{
				int value=l2.val+carry;
				if(value>9)
				{
					carry=1;
					value=value%10;
				}
				else
					carry=0;
				pointer.next=new ListNode(value);
				l2=l2.next;
				pointer=pointer.next;
			}
		}
		if(carry==1)
		{
			pointer.next=new ListNode(carry);
			pointer=pointer.next;
			carry=0;
		}
		return output.next;
	}
}
