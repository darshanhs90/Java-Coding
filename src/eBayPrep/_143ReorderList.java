package eBayPrep;

import java.util.Stack;

public class _143ReorderList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		//ln.next.next=new ListNode(3);
		//ln.next.next.next=new ListNode(4);
		//ln.next.next.next.next=new ListNode(5);
		//ln.next.next.next.next.next=new ListNode(6);
		//ln.next.next.next.next.next.next=new ListNode(7);
		reorderList(ln);
	}
	public static void reorderList(ListNode ln) {
		ListNode headNode=ln;
		int length=0;
		Stack<ListNode> stack=new Stack<>();
		while(ln!=null)
		{
			stack.push(ln);
			ln=ln.next;
			length++;
		}
		if(length<=2)
			return;
		ln=headNode;
		int counter=1;
		//length=(length/2)%2==0?length/2+1:(length/2);
		while(ln!=null && !stack.isEmpty() && counter<(length))
		{
			ListNode newNode=stack.pop();
			ListNode nextNode=ln.next;
			ln.next=newNode;
			newNode.next=nextNode;
			ln=nextNode;
			counter+=2;
		}
		ln.next=null;
		ln=headNode;
		while(ln!=null)
		{
			System.out.println(ln.val);
			ln=ln.next;
		}
	}
}

