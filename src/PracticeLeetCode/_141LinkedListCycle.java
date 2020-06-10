package PracticeLeetCode;

public class _141LinkedListCycle {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {

	}

	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null)
		{
			return false;
		}
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		while(slowPointer != null && fastPointer != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
			if(fastPointer != null)
			{
				fastPointer = fastPointer.next;
			}
			
			if(slowPointer == fastPointer)
				return true;
		}
		return false;
	}

}