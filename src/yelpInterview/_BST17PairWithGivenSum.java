package yelpInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class _BST17PairWithGivenSum {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,15);
		insert(n,10);
		insert(n,20);
		insert(n,8);
		insert(n,12);
		insert(n,16);
		insert(n,25);
		inOrderTraversal(n);
		System.out.println();
		System.out.println(hasTargetNodes(n,33));
	}



	static ArrayList<Integer> aList;

	private static boolean hasTargetNodes(Node n, int target) {
		if(n!=null)
		{
			aList=new ArrayList<>();
			populateList(n);
			Object[] arr=aList.toArray();
			Arrays.sort(arr);
			return checkSum(arr,target);
		}
		return false;
	}





	private static boolean checkSum(Object[] arr, int target) {
		int low=0,high=arr.length-1;
		while(low<high)
		{	
			int sum=(int)arr[low]+(int)arr[high];
			if(sum==target)
				return true;
			if(sum>target)
				high--;
			else
				low++;
		}
		return false;
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