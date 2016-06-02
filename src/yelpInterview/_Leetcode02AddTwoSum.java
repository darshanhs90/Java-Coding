package yelpInterview;

public class _Leetcode02AddTwoSum {

	static class ListNode{
		ListNode next;
		int val;
		public ListNode(int value) {
			this.val=value;
		}
	}
	public static void main(String a[]){
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		ListNode output=addTwoNumbers(l1, l2);
		while(output!=null)
		{
			System.out.println(output.val);
			output=output.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry=0;
		ListNode output=new ListNode(-1);
		ListNode pointer=output;
		while(l1!=null || l2!=null)
		{
			int sum=0;
			if(l1!=null && l2!=null)
			{
				sum=l1.val+l2.val+carry;
				l1=l1.next;l2=l2.next;
				if(sum>=10){
					String str=sum+"";
					carry=Integer.parseInt(str.charAt(0)+"");
					pointer.next=new ListNode(Integer.parseInt(str.charAt(1)+""));
				}
				else{
					pointer.next=new ListNode(sum);
				}
			}
			else if(l1!=null)
			{
				sum=l1.val+carry;
				l1=l1.next;
				if(sum>10){
					String str=sum+"";
					carry=Integer.parseInt(str.charAt(0)+"");
					pointer.next=new ListNode(Integer.parseInt(str.charAt(1)+""));
				}
			}
			else{
				sum=l2.val+carry;
				l2=l2.next;
				if(sum>10){
					String str=sum+"";
					carry=Integer.parseInt(str.charAt(0)+"");
					pointer.next=new ListNode(Integer.parseInt(str.charAt(1)+""));
				}
			}
			pointer=pointer.next;
		}
		return output.next;
	}
}

