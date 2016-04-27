package yelpInterview;

public class _BST04CheckBST {
	static class Node{
		int value;
		Node left,right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(4);
		n.left=new Node(2);
		n.right=new Node(5);
		n.left.left=new Node(1);
		n.left.right=new Node(3);
		System.out.println(isBST(n));
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
			if(n.value>maxValue || n.value<minValue)
				return false;
			return isBSTUtil(n.left, minValue, n.value-1) && isBSTUtil(n.right, n.value+1,maxValue);
		}
		return true;
	}







}