package hackerRank.DataStructures.LinkedList;

import java.util.Stack;

/*
 * Link:https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail
 */

public class _10GetNodeValue {

	int GetNode(Node head,int n) {
	      Stack<Integer> stack=new Stack<>();
		  while(head!=null)
	      {
	    	  stack.push(head.data);
	    	  head=head.next;
	      }
		  int counter=0;
		  while(counter!=n)
		  {
			  stack.pop();
			  counter++;
		  }
		return stack.pop();
	}
	class Node{
		Node next;
		int data;
	}


}
