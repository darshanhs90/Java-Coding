package yelpInterview;

public class _BT38DoubleTree {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(2);
		n.left=new Node(1);
		n.right=new Node(3);
		doubleTree(n);
		preOrder(n);
	}
	private static void doubleTree(Node n) {
		if(n!=null)
		{
			doubleTree(n.left);
			doubleTree(n.right);
			Node oldLeft = n.left;
			n.left=new Node(n.value);
			n.left.left=oldLeft;
		}

	}
	private static void preOrder(Node n) {
		if(n!=null)
		{
			System.out.println(n.value);
			preOrder(n.left);
			preOrder(n.right);
		}

	}


}

