package hackerRank.DataStructures.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/*
 * Link:https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list
 */

public class _11DeleteDuplicateValueSortedList {

	Node RemoveDuplicates(Node head) {
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

	class Node{
		Node next;
		int data;
	}


}
