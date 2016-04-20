package yelpInterview;

import java.util.Set;
import java.util.TreeSet;

public class _LL19RemoveDuplicatesUnSortedLL {
	static class Node{
		int value;
		Node next;
		public Node(int value) {
			this.value=value;
		}
	}

	public static void main(String a[]){
		Node n=new Node(12);
		n.next=new Node(11);
		n.next.next=new Node(12);
		n.next.next.next=new Node(21);
		n.next.next.next.next=new Node(41);
		n.next.next.next.next.next=new Node(43);
		n.next.next.next.next.next.next=new Node(21);
		n.next.next.next.next.next.next.next=new Node(12);
		
		n=removeDuplicates(n);
		print(n);
	}

	private static Node removeDuplicates(Node n) {
		Node outputNode=n;
		Set<Integer> set=new TreeSet<>();
		while(n!=null)
		{
			if(set.contains(n.value))
			{
				if(n.next!=null){
					n.value=n.next.value;
					n.next=n.next.next;
				}
				else{
					n=null;
				}
			}
			else{
				set.add(n.value);
				n=n.next;
			}
		}
		return outputNode;
	}









	private static void print(Node n) {
		while(n!=null)
		{
			System.out.print(n.value+"/");
			n=n.next;
		}
	}

}






