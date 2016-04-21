package yelpInterview;

public class _BT21DeepestLeftNode {
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
		//n.right.left.right.left=new Node(9);
		n.right.right.right=new Node(8);
		n.right.right.right.right=new Node(10);
		System.out.println(findDeepestLeftNode(n,0,false));
	}
	private static int findDeepestLeftNode(Node n,int level,boolean leftFlag) {
		if(n!=null){
			return 1+findDeepestLeftNodeUtil(n, level, leftFlag);
		}		
		return 0;
	}
	private static int findDeepestLeftNodeUtil(Node n, int i, boolean b) {
		if(n==null)
			return Integer.MIN_VALUE;
		if(b && n.left==null && n.right==null)
			return i;
		else {
			return Math.max(findDeepestLeftNodeUtil(n.left, i+1, true),findDeepestLeftNodeUtil(n.right, i+1, false));
		}
	}


}

