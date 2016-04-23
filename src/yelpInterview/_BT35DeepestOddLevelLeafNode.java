package yelpInterview;

public class _BT35DeepestOddLevelLeafNode {
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
		n.right.right.right=new Node(8);
		n.right.right.right.right=new Node(10);
		n.right.right.right.right.left=new Node(11);
		n.right.left.right=new Node(7);
		n.right.left.right.left=new Node(9);
		findDeepestLevelNode(n);
	}
	static Node node;
	private static void findDeepestLevelNode(Node n) {
		if(n!=null)
		{
			findDeepestLevelNodeUtil(n,0,true);
		}
		System.out.println(node.value);
	}
	private static void findDeepestLevelNodeUtil(Node n, int i, boolean b) {
		if(n!=null)
		{
			if(n.left==null && n.right==null && b && i%2==0)
				node=n;
			findDeepestLevelNodeUtil(n.left, i+1, true);
			findDeepestLevelNodeUtil(n.right, i+1, true);	
		}
	}
}

