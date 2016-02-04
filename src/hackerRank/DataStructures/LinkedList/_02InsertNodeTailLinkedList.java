package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
 */

public class _02InsertNodeTailLinkedList {

	Node Insert(Node head,int data) {
		Node headPointer=head;
		while(headPointer.next!=null)
		{
			headPointer=headPointer.next;
		}
		headPointer.next=new Node();
		headPointer.next.data=data;
		return head;
	}
	class Node{
		Node next;
		int data;
	}
}
