package yelpInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class _BST19BTToBSTConversion{
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(10);
		n.left=new Node(2);
		n.right=new Node(7);
		n.left.left=new Node(8);
		n.left.right=new Node(4);
		inOrderTraversal(n);
		System.out.println();
		convertTree(n);
		inOrderTraversal(n);
	}



	static ArrayList<Integer> aList;
	private static void convertTree(Node n) {
		if(n!=null)
		{
			aList=new ArrayList<>();
			populateList(n);
			Object[] arr=aList.toArray();
			Arrays.sort(arr);
			changeNodeVal(n,arr);
		}
	}





	static int counter=0;
	private static void changeNodeVal(Node n, Object[] arr) {
		if(n!=null)
		{
			changeNodeVal(n.left,arr);
			n.value=(int) arr[counter];
			counter++;
			changeNodeVal(n.right,arr);
		}
	}






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