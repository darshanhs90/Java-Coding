package yelpInterview;

public class _BT32BinaryTreeChangeSumTree {
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
		n.right.right=new Node(6);
		changeTree(n);
		inOrder(n);
	}
	private static void inOrder(Node n) {
		if(n!=null)
		{
			inOrder(n.left);
			System.out.println(n.value);
			inOrder(n.right);
		}
	}
	private static int changeTree(Node n) {
		if(n!=null)
		{
			if(n.left==null && n.right==null)
				return n.value;
			int leftSum=changeTree(n.left);
			int rightSum=changeTree(n.right);
			n.value+=leftSum;
			return n.value+rightSum;
		}
		return 0;
	}

}

