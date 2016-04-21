package yelpInterview;

public class _BT13DiameterOfBinaryTree {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(50);
		n.left=new Node(7);
		n.right=new Node(2);
		n.left.left=new Node(3);
		n.left.right=new Node(5);
		n.right.left=new Node(1);
		n.right.right=new Node(30);
		System.out.println(diameter(n));System.out.println();
	}
	private static int diameter(Node n) {
		if(n!=null)
		{
			int leftDiameter=diameter(n.left);
			int rightDiameter=diameter(n.right);
			int height=getHeight(n.left)+1+getHeight(n.right);
			return Math.max(height, Math.max(leftDiameter, rightDiameter));

		}
		return 0;
	}
	private static int getHeight(Node n) {
		if(n!=null)
		{
			return 1+Math.max(getHeight(n.left), getHeight(n.right));
		}
		return 0;
	}



}

