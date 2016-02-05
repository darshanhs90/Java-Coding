package hackerRank.DataStructures.LinkedList;

import java.util.Stack;

/*
 * Link:https://www.hackerrank.com/challenges/reverse-a-linked-list
 */

public class _07ReverseLinkedList {

	Node Reverse(Node head) {
		if(head==null)
			return head;
		Stack<Integer> stack=new Stack<>();
		while(head!=null)
		{
			stack.push(head.data);
			head=head.next;
		}
		Node n=new Node();
		head=n;
		while(!stack.isEmpty())
		{
			head.data=(stack.pop());
			head.next=!stack.isEmpty()?new Node():null;
			head=head.next;
		}
		return n;
	}
	class Node{
		Node next;
		int data;
	}
}
