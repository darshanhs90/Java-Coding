package leetCode;

import java.util.HashMap;

/*
 * Link : https://leetcode.com/problems/intersection-of-two-linked-lists/
 */

public class _160IntersectionLinkedLists {
	public static  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode nodeA=headA;
		ListNode nodeB=headB;
		int countA=0,countB=0;
		while(nodeA!=null){
			nodeA=nodeA.next;
			countA++;
		}
		while(nodeB!=null){
			nodeB=nodeB.next;
			countB++;
		}
		nodeA=headA;
		nodeB=headB;
		int counter=0;
		if(countA>countB)
		{
			while(counter<(countA-countB))
			{
				nodeA=nodeA.next;
				counter++;
			}
		}else if(countB>countA){
			while(counter<(countB-countA))
			{
				nodeA=nodeA.next;
				counter++;
			}
		}
		while(nodeA!=null && nodeB!=null){
			if(nodeA.val==nodeB.val)
			{
				return nodeA;
			}
			nodeA=nodeA.next;
			nodeB=nodeB.next;
		}
		return null;
	}
	public  static ListNode getIntersectionNodeExtraSpace(ListNode headA, ListNode headB) {
		HashMap<Integer, Integer> listMap=new HashMap<>();
		while(headA!=null)
		{
			listMap.put(headA.val, 1);
			headA=headA.next;
		}
		while(headB!=null)
		{	
			if(listMap.containsKey(headB.val))
			{
				return headB;
			}
			listMap.put(headB.val,1);
			headB=headB.next;
		}
		return null;
	}
	public  static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {

		ListNode ln=new ListNode(3);
		ln.next=new ListNode(6);
		ln.next.next=new ListNode(9);
		ln.next.next.next=new ListNode(15);
		ln.next.next.next.next=new ListNode(30);
		ListNode ln1=new ListNode(10);
		ln1.next=new ListNode(15);
		ln1.next.next=new ListNode(30);
		System.out.println(getIntersectionNode(ln, ln1).val);
		System.out.println(getIntersectionNodeExtraSpace(ln, ln1).val);

	}
}