package yelpInterview;

public class _BT06IdenticalTrees {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		n.right.left=new Node(6);
		n.right.right=new Node(7);
		Node n1=new Node(1);
		n1.left=new Node(2);
		n1.right=new Node(3);
		n1.left.left=new Node(4);
		n1.left.right=new Node(5);
		n1.right.left=new Node(6);
		n1.right.right=new Node(71);
		System.out.println(isIdentical(n,n1));System.out.println();
	}
	private static boolean isIdentical(Node n, Node n1) {
		if(n!=null && n1!=null)
		{
			return n1.value==n.value && isIdentical(n.left, n1.left) && isIdentical(n.right, n1.right);
		}
		else if(n!=null ||n1!=null)
			return false;
		return true;
	}


}

