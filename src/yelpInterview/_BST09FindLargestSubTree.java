package yelpInterview;

public class _BST09FindLargestSubTree {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(5);
		n.left=new Node(2);
		n.right=new Node(4);
		n.left.left=new Node(1);
		n.left.right=new Node(3);
		System.out.println(findLargestBSTUtil(n));
		Node root = new Node(50);
		root.left        = new Node(30);
		root.right       = new Node(60);
		root.left.left  = new Node(5);
		root.left.right = new Node(20);
		root.right.left  = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);
		System.out.println(findLargestBSTUtil(root));
	}
	private static int findLargestBSTUtil(Node n) {
		if(n!=null)
		{
			if(isBST(n)){
				return getSize(n);
			}
			else{
				return Math.max(findLargestBSTUtil(n.left), findLargestBSTUtil(n.right));
			}
		}
		return 0;
	}
	private static int getSize(Node n) {
		if(n!=null)
		{
			return 1+getSize(n.left)+getSize(n.right);
		}
		return 0;
	}
	private static boolean isBST(Node n) {
		if(n!=null)
		{
			return isBSTUtil(n,Integer.MIN_VALUE,Integer.MAX_VALUE);
		}
		return true;
	}
	private static boolean isBSTUtil(Node n, int minValue, int maxValue) {
		if(n!=null)
		{
			if(n.value>=minValue && n.value<=maxValue)
				return isBSTUtil(n.left, minValue, n.value-1) && isBSTUtil(n.right, n.value+1, maxValue);
			else
				return false;
		}
		return true;
	}



}