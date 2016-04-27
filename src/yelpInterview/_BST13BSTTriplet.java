package yelpInterview;

import java.util.Arrays;

public class _BST13BSTTriplet {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,6);
		insert(n,-13);
		insert(n,14);
		insert(n,-8);
		insert(n,13);
		insert(n,15);
		insert(n,7);
		inOrderTraversal(n);
		System.out.println();
		System.out.println(hasTriplet(n,0));
	}
	private static boolean hasTriplet(Node n, int i) {
		if(n!=null)
		{
			int size=getSize(n);
			int []treeArr=new int[size];
			populateArr(n,treeArr);
			Arrays.sort(treeArr);
			return hasTripleZeroSum(treeArr);
		}
		return false;
	}
	private static boolean hasTripleZeroSum(int[] treeArr) {
		for (int i = 0; i < treeArr.length-2; i++) {
			int low=i+1;
			int high=treeArr.length-1;
			while(low<high)
			{
				int value=treeArr[low]+treeArr[high]+treeArr[i];
				if(value==0)
					return true;
				else if(value>0)
					high--;
				else
					low++;
			}
		}
		return false;
	}
	private static void populateArr(Node n,int[] treeArr) {
		if(n!=null)
		{
			treeArr[counter]=n.value;
			counter++;
			populateArr(n.left, treeArr);
			populateArr(n.right, treeArr);
		}
	}
	private static int getSize(Node n) {
		if(n!=null)
		{
			return 1+getSize(n.left)+getSize(n.right);
		}
		return 0;
	}
	static int counter=0;




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