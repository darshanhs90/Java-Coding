package appleInterview;

import java.util.Arrays;

public class _DS_BT_09RootToLeafPath {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	static int path[]=new int[1000];
	public static void main(String[] args) {
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		printRootPath(n,path,0);
	}
	private static void printRootPath(Node n, int[] path, int pathLen) {
		if(n!=null)
		{
			path[pathLen]=n.value;
			pathLen++;
			if(n.left==null && n.right==null)
			{
				System.out.println(Arrays.toString(Arrays.copyOfRange(path, 0, pathLen)));
			}
			printRootPath(n.left, path, pathLen);
			printRootPath(n.right, path, pathLen);
		}
	}
}

