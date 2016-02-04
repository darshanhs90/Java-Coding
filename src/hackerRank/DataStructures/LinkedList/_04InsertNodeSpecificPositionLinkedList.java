package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
 */

public class _04InsertNodeSpecificPositionLinkedList {

	Node InsertNth(Node head, int data, int position) {
		Node newNode=new Node();
		newNode.data=data;
		Node headNode=head;
		if(head==null||position==0)
		{	
			newNode.next=head;
			return newNode;
		}
		else{
			while(head!=null && position>1)
			{
				position--;
				head=head.next;
			}
			newNode.next=head.next;
			head.next=newNode;	
		}
		return headNode;
	}
	class Node{
		Node next;
		int data;
	}
}
