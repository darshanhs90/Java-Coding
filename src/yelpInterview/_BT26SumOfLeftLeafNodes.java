package yelpInterview;

public class _BT26SumOfLeftLeafNodes {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(20);
		n.left=new Node(9);
		n.right=new Node(49);
		n.left.left=new Node(5);
		n.left.right=new Node(12);
		n.left.right.right=new Node(15);
		n.right.left=new Node(23);
		n.right.right=new Node(52);
		n.right.right.left=new Node(50);
		System.out.println(findLeftLeafSum(n));
	}
	private static int findLeftLeafSum(Node n) {
		return findLeftLeafSumUtil(n,true);
	}
	private static int findLeftLeafSumUtil(Node n, boolean b) {
		if(n!=null)
		{
			if(b && n.left==null && n.right==null)
				return n.value;
			else
			{
				return findLeftLeafSumUtil(n.left, true)+findLeftLeafSumUtil(n.right, false);
			}
		}
		return 0;
	}

}

