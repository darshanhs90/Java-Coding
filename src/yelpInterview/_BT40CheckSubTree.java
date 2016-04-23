package yelpInterview;

public class _BT40CheckSubTree {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n1=new Node(26);
		n1.left=new Node(10);
		n1.right=new Node(3);
		n1.right.right=new Node(3);
		n1.left.left=new Node(4);
		n1.left.right=new Node(6);
		n1.left.left.right=new Node(30);

		Node n2=new Node(10);
		n2.left=new Node(4);
		n2.right=new Node(6);
		n2.left.right=new Node(30);
		System.out.println(checkSubTree(n1,n2));
	}
	private static boolean checkSubTree(Node n1, Node n2) {
		if(n1==null)
			return false;
		if(n2==null)
			return false;
		if(isIdentical(n1,n2))
		{
			return true;
		}
		return checkSubTree(n1.left, n2)||checkSubTree(n1.right, n2);
	}
	private static boolean isIdentical(Node n1, Node n2) {
		if(n1==null && n2==null)
			return true;
		if(n1==null || n2==null)
			return false;
		return n1.value==n2.value && isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
	}
}

