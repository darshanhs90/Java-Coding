package yelpInterview;

public class _BT01TreeTraversals {

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
		preOrder(n);System.out.println();
		postOrder(n);System.out.println();
		inOrder(n);System.out.println();
	}
	private static void inOrder(Node n) {
		if(n!=null)
		{
			inOrder(n.left);
			System.out.print(n.value+"/");
			inOrder(n.right);
		}
	}
	private static void postOrder(Node n) {
		if(n!=null)
		{
			System.out.print(n.value+"/");
			postOrder(n.left);
			postOrder(n.right);
		}
	}
	private static void preOrder(Node n) {
		if(n!=null)
		{
			preOrder(n.left);
			preOrder(n.right);
			System.out.print(n.value+"/");
		}
	}

}

