package servicenowPrep;

import java.util.Stack;

public class _013CheckPalindromeList {

	static class ListNode{
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value=value;
		}
	}

	public static void main(String[] args) {
		ListNode ln=new ListNode(2);
		ln.next=new ListNode(3);
		ln.next.next=new ListNode(5);
		ln.next.next.next=new ListNode(3);
		ln.next.next.next.next=new ListNode(2);
		System.out.println(isPalindrome(ln));
	}

	private static boolean isPalindrome(ListNode ln) {
		ListNode pointer=ln;
		Stack<Integer> stack=new Stack<>();
		while(pointer!=null)
		{
			stack.push(pointer.value);
			pointer=pointer.next;
		}
		while(ln!=null)
		{
			if(ln.value!=stack.pop())
				return false;
			ln=ln.next;
		}
		return true;
	}

	


}
