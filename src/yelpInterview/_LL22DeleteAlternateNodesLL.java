package yelpInterview;

import java.util.HashSet;
import java.util.Set;

public class _LL22DeleteAlternateNodesLL {
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
		n=deleteNodes(n);
		print(n);
	}




	private static Node deleteNodes(Node n) {
		Node outputNode=n;
		while(n!=null)
		{	
			if(n.next!=null)
				n.next=n.next.next;
			n=n.next;
		}
		return outputNode;
	}




	private static void print(Node n) {
		while(n!=null)
		{
			System.out.print(n.value+"/");
			n=n.next;
		}
	}

}






