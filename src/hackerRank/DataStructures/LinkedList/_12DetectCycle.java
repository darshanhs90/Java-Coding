package hackerRank.DataStructures.LinkedList;

/*
 * Link:https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
 */

public class _12DetectCycle {


	int HasCycle(Node head) {
		Node slowPointer=head;
		Node fastPointer=head;
		while(fastPointer!=null)
		{
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next;
			if(fastPointer==null)
				break;
			fastPointer=fastPointer.next;

			if(slowPointer==fastPointer)
				return 1;
		}
		return 0;
	}

	class Node{
		Node next;
		int data;
	}


}
