package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/compare-two-linked-lists
 */

public class _08CompareLinkedLists {

	int CompareLists(Node headA, Node headB) {
	    if((headA!=null && headB==null )||(headA==null && headB!=null))
	    {
	    	return 0;
	    }
	    else{
	    	while(headA!=null && headB!=null)
	    	{
	    		if(headA.data!=headB.data)
	    			return 0;
	    		headA=headA.next;
	    		headB=headB.next;
	    	}
	    	return headA==headB?1:0;
	    }
	}
	class Node{
		Node next;
		int data;
	}
}
