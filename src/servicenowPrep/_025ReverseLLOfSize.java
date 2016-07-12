package servicenowPrep;

import java.util.Stack;

public class _025ReverseLLOfSize {

	static class ListNode{
		int value;
		public ListNode(int value) {
			this.value=value;
		}
		ListNode next;

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
		ln=reverseLL(ln,3);
		System.out.println("****");
		while(ln!=null)
		{
			System.out.println(ln.value);
			ln=ln.next;
		}
	}
	private static ListNode reverseLL(ListNode ln, int k) {
		
		ListNode output=ln;
		ListNode outputNode=output;
		while(ln!=null)
		{
			ListNode pointer=ln;
			Stack<ListNode> stack=new Stack<>();
			for (int i = 0; i < k; i++) {
				if(pointer!=null){
					stack.push(pointer);
					pointer=pointer.next;
				}
			}

			while(!stack.isEmpty())
			{
				output.next=stack.pop();
				output=output.next;
			}
			//output.next=null;
			ln=pointer;
		}
		output.next=null;
		return outputNode;
	}




}
