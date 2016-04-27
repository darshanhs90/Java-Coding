package yelpInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class _BST14TwoNodesSwapped {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(10);
		n.left=new Node(5);
		n.right=new Node(8);
		n.left.left=new Node(2);
		n.left.right=new Node(20);
		inOrderTraversal(n);
		System.out.println();
		correctBST(n);
		inOrderTraversal(n);
	}


	static ArrayList<Integer> aList;
	private static void correctBST(Node n) {
		aList=new ArrayList<>();
		addToList(n);
		Object arr[]=aList.toArray();
		Arrays.sort(arr);
		int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(aList.get(i)!=arr[i])
			{
				if(first==Integer.MIN_VALUE){
					first=aList.get(i);
				}
				else{
					second=aList.get(i);
					break;
				}
			}
		}
		changeNodeVal(n,first,second);
	}



	private static void changeNodeVal(Node n, int first, int second) {
		if(n!=null)
		{
			changeNodeVal(n.left, first, second);
			if(n.value==first)
				n.value=second;
			else if(n.value==second)
				n.value=first;
			changeNodeVal(n.right, first, second);
		}
	}



	private static void addToList(Node n) {
		if(n!=null)
		{
			addToList(n.left);
			aList.add(n.value);
			addToList(n.right);
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