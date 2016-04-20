package yelpInterview;

import java.util.Stack;

public class _LL25ReverseLLAlternateK {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(1);
		n.next=new Node(2);
		n.next.next=new Node(3);
		n.next.next.next=new Node(4);
		n.next.next.next.next=new Node(5);
		n.next.next.next.next.next=new Node(6);
		n.next.next.next.next.next.next=new Node(7);
		n.next.next.next.next.next.next.next=new Node(8);
		n=reverseLL(n,5);
		print(n);
	}


	private static Node reverseLL(Node n,int k) {
		Node outputNode=new Node(-1);
		Node ptr=outputNode;
		while(n!=null)
		{
			Stack<Integer> stack=new Stack<>();
			for (int i = 0; i < k; i++) {
				if(n!=null)
					stack.push(n.value);
				else
					break;
				n=n.next;
			}
			while(!stack.isEmpty())
			{
				outputNode.next=new Node(stack.pop());
				outputNode=outputNode.next;
			}
		}
		return ptr.next;
	}










	private static void print(Node n) {
		while(n!=null)
		{
			System.out.print(n.value+"/");
			n=n.next;
		}
	}

}






