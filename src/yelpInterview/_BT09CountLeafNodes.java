package yelpInterview;

public class _BT09CountLeafNodes {
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
		System.out.println(countLeafNodes(n));System.out.println();
	}
	private static int countLeafNodes(Node n) {
		if(n!=null)
		{
			if(n.left==null && n.right==null)
				return 1;
			return countLeafNodes(n.left)+countLeafNodes(n.right);
		}
		return 0;
	}
}

