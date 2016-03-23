package appleInterview;

import java.util.Stack;

public class _DS_LL_04ReverseLLIterative {

	static class Node{
		Node next;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(1);
		n.next=new Node(2);
		n.next.next=new Node(3);
		n.next.next.next=new Node(4);
		n.next.next.next.next=new Node(5);
		n.next.next.next.next.next=new Node(6);
		print(n);
		//n=reverseIterativeExtraSpace(n);
		n=reverseIterative(n);
		print(n);

	}

	private static Node reverseIterativeExtraSpace(Node n) {
		Stack<Integer> valueStack=new Stack<Integer>();
		Node temp=n;
		Node newHead=n;
		while(n!=null)
		{
			valueStack.push(n.value);
			n=n.next;
		}
		while(!valueStack.isEmpty()){
			temp.value=valueStack.pop();
			temp=temp.next;
		}
		return newHead;
	}

	private static Node reverseIterative(Node n) {
		Node prev=null;
		Node current=n;
		Node next;
		
		while(current!=null)
		{
			next=current.next;
			current.next = prev;   
	        prev = current;
	        current = next;
		}
		return prev;
	}

	private static void print(Node n) {
		while(n!=null){
			System.out.print(n.value+"/");
			n=n.next;
		}
		System.out.println();
	}

}
