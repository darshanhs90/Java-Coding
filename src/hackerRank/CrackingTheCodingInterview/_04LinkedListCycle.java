package hackerRank.CrackingTheCodingInterview;

public class _04LinkedListCycle {

	class Node {
		int data;
		Node next;
	}

	static boolean hasCycle(Node head) {
		if(head==null||head.next==null)
			return false;
		Node fastPointer=head.next.next;
		Node slowPointer=head;
		while(fastPointer!=null && slowPointer!=null)
		{
			if(slowPointer==fastPointer)
				return true;
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next;
			if(fastPointer!=null)
				fastPointer=fastPointer.next;
		}
		return false;
	}
}
