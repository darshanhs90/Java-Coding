package LeetcodeTemplate;

public class _0141LinkedListCycle {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode ln03 = new ListNode(3);
		ListNode ln02 = new ListNode(2);
		ListNode ln00 = new ListNode(0);
		ListNode ln04 = new ListNode(4);
		ln03.next = ln02;
		ln02.next = ln00;
		ln00.next = ln04;
		ln04.next = ln02;		
		System.out.println(hasCycle(ln03));
		
		ListNode ln01 = new ListNode(1);
		ln02 = new ListNode(2);
		ln01.next = ln02;
		ln02.next = ln01;
		System.out.println(hasCycle(ln01));
		
		ln01 = new ListNode(1);
		System.out.println(hasCycle(ln01));
		
		ln01 = new ListNode(1);
		ln01.next = new ListNode(2);
		ln01.next.next = new ListNode(3);
		ln01.next.next.next = new ListNode(4);
		System.out.println(hasCycle(ln01));
		
	}

}
