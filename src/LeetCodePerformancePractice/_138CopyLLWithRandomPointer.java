package LeetCodePerformancePractice;

public class _138CopyLLWithRandomPointer {
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	public static void main(String[] args) {

	}
	public RandomListNode copyRandomList(RandomListNode head) {

		if(head==null)
			return head;
		RandomListNode rn=head;
		while(rn!=null)
		{
			RandomListNode newRn=new RandomListNode(rn.label);
			newRn.next=rn.next;
			rn.next=newRn;
			rn=newRn.next;
		}
		rn=head;
		while(rn!=null)
		{
			if(rn.random!=null)
			{
				rn.next.random=rn.random.next;
			}
			rn=rn.next.next;
		}
		rn=head;
		RandomListNode newHead=head.next;
		while(rn!=null)
		{
			RandomListNode temp=rn.next;
			rn.next=temp.next;
			if(temp.next!=null)
				temp.next=temp.next.next;
			rn=rn.next;
		}
		return newHead;

	}
}
