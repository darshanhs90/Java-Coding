package yelpInterview;

public class _BT27FindMinDepth {
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
		System.out.println(findMinDepth(n,1));
	}
	private static int findMinDepth(Node n,int level) {
		if(n!=null)
		{
			if(n.left==null && n.right==null)
				return level;
			return Math.min(findMinDepth(n.left, level+1), findMinDepth(n.right, level+1));
		}
		return Integer.MAX_VALUE;
	}


}

