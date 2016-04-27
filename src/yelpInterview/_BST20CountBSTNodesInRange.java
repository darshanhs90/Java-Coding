package yelpInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class _BST20CountBSTNodesInRange{
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=insert(null,10);
		insert(n,5);
		insert(n,1);
		insert(n,50);
		insert(n,40);
		insert(n,100);
		inOrderTraversal(n);
		System.out.println();
		System.out.println("value is "+findNodes(n,5,45));
	}







	private static int findNodes(Node n,int min,int max) {
		if(n!=null)
		{
			if(n.value>=min && n.value<=max)
			{	
				System.out.print(n.value+" ");
				return 1+findNodes(n.left, min, max)+findNodes(n.right, min, max);
			}
			else if(n.value>max)
				return findNodes(n.left, min, max);
			else if(n.value<min)
				return findNodes(n.right, min, max);
		}
		return 0;
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