package servicenowPrep;

import java.util.Stack;

public class _026DeleteNodesGreaterValue {

	static class ListNode{
		int value;
		public ListNode(int value) {
			this.value=value;
		}
		ListNode next;

	}
	//12->15->10->11->5->6->2->3
	public static void main(String[] args) {
		ListNode ln=new ListNode(12);
		ln.next=new ListNode(15);
		ln.next.next=new ListNode(10);
		ln.next.next.next=new ListNode(11);
		ln.next.next.next.next=new ListNode(5);
		ln.next.next.next.next.next=new ListNode(6);
		ln.next.next.next.next.next.next=new ListNode(2);
		ln.next.next.next.next.next.next.next=new ListNode(3);
		ln=removeNodes(ln);
		System.out.println("**********");
		while(ln!=null)
		{
			System.out.println(ln.value);
			ln=ln.next;
		}
	}
	private static ListNode removeNodes(ListNode ln) {
		ln=reverseLL(ln);
		ln=removeNodesGreater(ln);
		ln=reverseLL(ln);
		return ln;
	}
	private static ListNode removeNodesGreater(ListNode ln) {
		ListNode prev=null,curr=ln;
		ListNode output=new ListNode(-1),pointer=output;
		while(curr!=null)
		{
			if(prev==null||curr.value>prev.value)
			{
				prev=curr;
				output.next=prev;
				output=output.next;
				System.out.println(prev.value);
				curr=curr.next;
			}
			else if(curr.value<prev.value){
				curr=curr.next;
			}
		}
		output.next=null;
		return pointer.next;
	}
	private static ListNode reverseLL(ListNode ln) {
		Stack<ListNode> stack=new Stack<ListNode>();
		ListNode newPointer=new ListNode(-1),output=newPointer;
		while(ln!=null)
		{
			stack.push(ln);
			ln=ln.next;
		}
		while(!stack.isEmpty())
		{
			newPointer.next=stack.pop();
			newPointer=newPointer.next;
		}		
		newPointer.next=null;
		return output.next;
	}

}
