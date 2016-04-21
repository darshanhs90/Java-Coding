package yelpInterview;

public class _BT15RootToLeafPathSum {
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
		System.out.println(hasRootToLeafSumPath(n,60));
		System.out.println();
	}
	private static boolean hasRootToLeafSumPath(Node n, int i) {
		if(n!=null){
			if(n.value-i==0)
				return true;
			return hasRootToLeafSumPath(n.left, i-n.value)|| hasRootToLeafSumPath(n.right, i-n.value);
		}
		return false;
	}



}

