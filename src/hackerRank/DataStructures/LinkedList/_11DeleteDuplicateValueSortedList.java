package hackerRank.DataStructures.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/*
 * Link:https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list
 */

public class _11DeleteDuplicateValueSortedList {

	static Node RemoveDuplicates(Node head) {
		if(head==null)
			return head;
		TreeSet<Integer> nodeMap=new TreeSet<>();
		Queue<Integer> q=new LinkedList<>();
		while(head!=null)
		{	
			if(!nodeMap.contains(head.data))
			{	
				nodeMap.add(head.data);
				q.add(head.data);
			}
			head=head.next;
		}
		Node n=new Node();
		Node q1=n;
		while(!q.isEmpty())
		{
			n.data=q.poll();
			if(!q.isEmpty())
				n.next=new Node();
			n=n.next;
		}
		return q1;
	} 
	
	public static void main(String[] args) {
		Node n=new Node();
		n.data=1;n.next=new Node();
		n.next.data=1;n.next.next=new Node();
		n.next.next.data=1;
		n=RemoveDuplicates(n);
		while(n!=null)
		{
			System.out.println(n.data);n=n.next;
		}
	}
	
	
	static class Node{
		Node next;
		int data;
	}


}
