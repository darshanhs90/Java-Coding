package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
 */

public class _09MergeTwoSortedLinkedLists {

	Node MergeLists(Node headA, Node headB) {
		if(headA==null && headB==null)
			return null;

		if(headA==null && headB!=null)
			return headB;
		else if(headA!=null && headB==null)
			return headA;

		Node newNode=new Node();
		Node newHead=newNode;
		while(headA!=null && headB!=null)
		{
			if(headA.data<headB.data)
			{
				newNode.data=headA.data;
				headA=headA.next;
			}
			else
			{
				newNode.data=headB.data;
				headB=headB.next;	    		
			}
			if(headA!=null && headB!=null)
			{
				newNode.next=new Node();
				newNode=newNode.next;
			}
		}
		if(headA==null && headB==null)
			newNode=null;
		else if(headA==null)
		{
			newNode.next=headB;
		}
		else{
			newNode.next=headA;
		}
		return newHead;
	}
	class Node{
		Node next;
		int data;
	}
}
