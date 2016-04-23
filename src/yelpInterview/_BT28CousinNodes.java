package yelpInterview;

public class _BT28CousinNodes {
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(6);
		n.left=new Node(3);
		n.right=new Node(5);
		n.left.left=new Node(7);
		n.left.right=new Node(8);
		n.right.left=new Node(1);
		n.right.right=new Node(3);
		System.out.println(checkCousins(n,3,5));
	}
	private static boolean checkCousins(Node n, int i, int j) {
		if(n!=null)
		{
			return level(n,i,0)==level(n,j,0) && !isSiblings(n,i,j);
		}
		return false;
	}
	private static boolean isSiblings(Node n, int a, int b) {
		if(n!=null)
		{
			if(n.left!=null && n.right!=null)
			{
				return (n.left.value==a && n.right.value==b)||( n.right.value==a && n.left.value==b) 
						|| isSiblings(n.left, a, b)|| isSiblings(n.right, a, b);
			}
			else if(n.left!=null)
			{
				return isSiblings(n.left, a, b);
			}else if(n.right!=null)
			{
				return isSiblings(n.right, a, b);
			}
		}
		return false;
	}
	private static int level(Node n, int i, int level) {
		if(n!=null)
		{
			if(n.value==i)
				return level;
			if(n.left!=null)
			{
				int val=level(n.left,i,level+1);
				if(val!=-1)
					return val;
			}
			return level(n.right,i,level+1);
		}
		return -1;
	}

}

