package yelpInterview;

import java.util.Arrays;

public class _BT08PrintRootToLeafPath {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	static int[]path=new int[100];
	public static void main(String a[]){
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		n.right.left=new Node(6);
		n.right.right=new Node(7);
		printPaths(n,path,0);System.out.println();
	}
	private static void printPaths(Node n, int[] path, int level) {
		if(n!=null)
		{
			path[level]=n.value;
			if(n.left==null && n.right==null)
			{
				System.out.println(Arrays.toString(path));
			}
			printPaths(n.left, path, level+1);
			printPaths(n.right, path, level+1);
		}
	}
}

