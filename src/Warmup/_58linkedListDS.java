package Warmup;

/*
 * Link:https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list 
 */	
public class _58linkedListDS {
	public static void main(String[] args) {
		Node n=new Node();
		n.data=1;
		n.next=new Node();
		n.next.data=2;
		n=Insert(n,3);
		while(n!=null)
		{
			System.out.println(n.data);
			n=n.next;
		}
	}
	/*
	  Insert Node at the end of a linked list 
	  head pointer input could be NULL as well for empty list
	  Node is defined as */
	static class Node {
		int data;
		Node next;
	}
	/**/
	static Node Insert(Node head,int data) {
		// This is a "method-only" submission. 
		// You only need to complete this method. 
		Node n=head;
		while(n!=null && n.next!=null)
		{
			n=n.next;    
		}
		n.next=new Node();
		n.next.data=data;
		n.next.next=null;
		return head;
	}


}