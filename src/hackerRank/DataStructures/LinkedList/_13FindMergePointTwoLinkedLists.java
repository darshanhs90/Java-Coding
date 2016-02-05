package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
 */

public class _13FindMergePointTwoLinkedLists {


	int FindMergeNode(Node headA, Node headB) {
		int lengthA=0,lengthB=0;
		Node headNodeA=headA;
		Node headNodeB=headB;
		while(headA!=null)
		{
			lengthA++;
			headA=headA.next;
		}
		while(headB!=null)
		{
			lengthB++;
			headB=headB.next;
		}
		if(lengthA>lengthB)
		{
			return findMerge(lengthA,lengthB,headNodeA,headNodeB);
		}
		else{
			return findMerge(lengthB,lengthA,headNodeB,headNodeA);
		}
	}

	private int findMerge(int lengthA, int lengthB, Node headA, Node headB) {
		int diff=Math.abs(lengthA-lengthB);
		int count=0;
		while(count!=diff)
		{
			headA=headA.next;
			count++;
		}

		while(headA.data!=headB.data)
		{
			headA=headA.next;
			headB=headB.next;
		}
		return headA.data;
	}

	class Node{
		Node next;
		int data;
	}
}
