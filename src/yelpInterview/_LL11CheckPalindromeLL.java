package yelpInterview;

import java.util.Stack;

public class _LL11CheckPalindromeLL {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(1);
		n.next=new Node(2);
		n.next.next=new Node(3);
		n.next.next.next=new Node(33);
		n.next.next.next.next=new Node(2);
		n.next.next.next.next.next=new Node(1);
		System.out.println(checkPalindrome(n));
	}

	private static boolean checkPalindrome(Node n) {
		Node pointer=n;
		Stack<Integer> stack=new Stack<>();
		while(n!=null){
			stack.push(n.value);
			n=n.next;
		}
		while(!stack.isEmpty()){
			if(pointer.value!=stack.pop())
				return false;
			pointer=pointer.next;
		}
		return true;
	}



}






