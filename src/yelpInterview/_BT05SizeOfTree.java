package yelpInterview;

public class _BT05SizeOfTree {
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
		System.out.println(sizeOf(n));System.out.println();
	}
	private static int sizeOf(Node n) {
		if(n!=null)
		{
			return 1+sizeOf(n.left)+sizeOf(n.right);
		}
		return 0;
	}

}

