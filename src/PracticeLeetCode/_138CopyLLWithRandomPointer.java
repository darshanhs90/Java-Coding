package PracticeLeetCode;

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
		RandomListNode headPointer=head;
		//copy node
		while(headPointer!=null)
		{
			RandomListNode temp=new RandomListNode(headPointer.label);
			temp.next=headPointer.next;
			headPointer.next=temp;
			headPointer=temp.next;
		}

		headPointer=head;
		//copy random pointers

		while(headPointer!=null)
		{
			if(headPointer.random!=null)
			{
				headPointer.next.random=headPointer.random.next;
			}
			headPointer=headPointer.next.next;
		}

		headPointer=head;
		//differentiate lists
		RandomListNode output=headPointer.next;
		while(headPointer!=null)
		{
			RandomListNode temp=headPointer.next;
			headPointer.next=temp.next;
			if(temp.next!=null)
			{
				temp.next=temp.next.next;
			}
			headPointer=headPointer.next;
		}
		return output;
	}
}