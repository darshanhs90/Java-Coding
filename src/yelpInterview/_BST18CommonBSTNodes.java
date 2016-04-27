package yelpInterview;

import java.util.ArrayList;
import java.util.HashSet;

public class _BST18CommonBSTNodes {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null, 5);
		insert(n, 1);
		insert(n, 10);
		insert(n,  0);
		insert(n,  4);
		insert(n,  7);
		insert(n,  9);
		inOrderTraversal(n);
		System.out.println();
		Node n2=insert(null, 10);
		insert(n2, 7);
		insert(n2, 20);
		insert(n2, 4);
		insert(n2, 9);
		inOrderTraversal(n2);
		findCommonNodes(n,n2);
	}



	private static void findCommonNodes(Node n, Node n2) {
		aList=new ArrayList<>();
		populateList(n);
		Object arr1[]=aList.toArray();
		aList=new ArrayList<>();
		populateList(n2);
		Object arr2[]=aList.toArray();
		printIntersection(arr1,arr2);
	}



	private static void printIntersection(Object[] arr1, Object[] arr2) {
		HashSet<Integer> set=new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add((int)arr1[i]);
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			if(set.contains((int)arr2[i]))
			{
				System.out.print(arr2[i]+" ");
			}
		}
	}



	static ArrayList<Integer> aList;
	private static void populateList(Node n) {
		if(n!=null)
		{
			populateList(n.left);
			aList.add(n.value);
			populateList(n.right);
		}
	}





	private static void inOrderTraversal(Node n) {
		if(n!=null)
		{
			inOrderTraversal(n.left);
			System.out.print(n.value+" ");
			inOrderTraversal(n.right);
		}
	}

	private static Node insert(Node n, int value) {
		if(n==null)
			return new Node(value);
		if(n.value>value)
		{//move left
			n.left=insert(n.left,value);
		}
		else{//move right
			n.right=insert(n.right,value);			
		}
		return n;
	}

}