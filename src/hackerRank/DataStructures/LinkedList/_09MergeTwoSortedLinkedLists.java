package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
 */

public class _09MergeTwoSortedLinkedLists {

	static Node MergeLists(Node headA, Node headB) {
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
	static class Node{
		Node next;
		int data;
	}


	public static void main(String[] args) {
		Node a=new Node();
		a.data=1;a.next=new Node();
		a.next.data=3;a.next.next=new Node();
		a.next.next.data=5;a.next.next.next=new Node();
		a.next.next.next.data=6;

		Node b=new Node();
		b.data=2;b.next=new Node();
		b.next.data=4;b.next.next=new Node();
		b.next.next.data=7;

		a=MergeLists(a, b);
		while(a!=null)
		{
			System.out.println(a.data);
			a=a.next;
		}

	}
}
