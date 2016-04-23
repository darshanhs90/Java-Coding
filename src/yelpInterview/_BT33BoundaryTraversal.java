package yelpInterview;

public class _BT33BoundaryTraversal {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(20);
		n.left=new Node(8);
		n.right=new Node(22);
		n.left.left=new Node(4);
		n.left.right=new Node(12);
		n.right.right=new Node(25);
		n.left.right.left=new Node(10);
		n.left.right.right=new Node(14);
		boundaryTraverse(n);
	}
	private static void boundaryTraverse(Node n) {
		if(n!=null)
		{
			printLeftNodes(n);
			printLeafNodes(n);
			printRightNodes(n);
		}
	}
	private static void printRightNodes(Node n) {
		if(n!=null)
		{
			printRightNodes(n.right);
			System.out.println(n.value);
		}

	}
	private static void printLeafNodes(Node n) {
		if(n!=null)
		{
			if(n.left==null && n.right==null)
				System.out.println(n.value);
			printLeafNodes(n.left);
			printLeafNodes(n.right);

		}
	}
	private static void printLeftNodes(Node n) {
		if(n!=null)
		{
			System.out.println(n.value);
			printLeftNodes(n.left);
		}
	}


}

