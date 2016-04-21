package yelpInterview;

public class _BT22MaxWidthOfBinaryTree {
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
		n.right.left=new Node(5);
		n.right.right=new Node(6);
		n.right.left.right=new Node(7);
		n.right.left.right.left=new Node(9);
		n.right.right.right=new Node(8);
		n.right.right.right.right=new Node(10);
		System.out.println(findmaxWidth(n));
	}
	private static int findmaxWidth(Node n) {
		int width=0;
		for (int i = 0; i < getHeight(n); i++) {
			width=Math.max(width,getWidth(n,i));
		}
		return width;
	}
	private static int getWidth(Node n, int i) {
		if(n!=null)
		{
			if(i==0)
				return 1;
			else if(i>0)
			{
				return getWidth(n.left, i-1)+getWidth(n.right, i-1);
			}
		}
		return 0;
	}
	private static int getHeight(Node n) {
		return n!=null?1+Math.max(getHeight(n.left), getHeight(n.right)):0;
	}

}

