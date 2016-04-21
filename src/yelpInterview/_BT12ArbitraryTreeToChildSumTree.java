package yelpInterview;

public class _BT12ArbitraryTreeToChildSumTree {
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
		convertSumTree(n);
		preOrder(n);
		System.out.println();
	}
	private static void preOrder(Node n) {
		if(n!=null)
		{
			preOrder(n.left);System.out.print(n.value+"/");preOrder(n.right);
		}
	}
	private static void convertSumTree(Node n) {
		if(n!=null)
		{
			convertSumTree(n.left);
			convertSumTree(n.right);
			int leftVal=n.left!=null?n.left.value:0;
			int rightVal=n.right!=null?n.right.value:0;
			int diff=-n.value+leftVal+rightVal;
			if(diff>0)
			{
				n.value+=diff;
			}
			if(diff<0)
			{
				increment(n,-diff);
			}
		}

	}
	private static void increment(Node n, int i) {
		if(n.left!=null){
			n.left.value+=i;
			increment(n.left,i);
		}
		else if(n.right!=null){
			n.right.value+=i;
			increment(n.right,i);
		}
	}


}

