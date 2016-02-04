package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list
 */

public class _01PrintElements {

	void Print(Node head) {
		while(head!=null)
		{
			System.out.println(head.data);
			head=head.next;
		}
	}
	class Node{
		Node next;
		int data;
	}
}
