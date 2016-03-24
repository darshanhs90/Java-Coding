package appleInterview;

import java.util.ArrayList;
import java.util.List;

public class _07PrepDocCollapseBSTSortedList {
	static class Node{Node left,right;int value;
		public Node( int value){this.value=value;}
	}
	static List<Integer> l;
	public static void main(String[] args) {
		Node n=new Node(5);
		n.left=new Node(3);
		n.right=new Node(7);
		n.left.left=new Node(1);
		n.left.right=new Node(4);
		n.right.left=new Node(6);
		n.right.right=new Node(8);
		l=convertSorted(n);
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i)+"/");
		}
	}
	private static List<Integer> convertSorted(Node n) {
		l=new ArrayList<>();
		sortedOrder(n);
		return l;
	}
	private static void sortedOrder(Node n) {
		if(n!=null)
		{
			sortedOrder(n.left);
			l.add(n.value);
			sortedOrder(n.right);
		}
	}

}
