package yelpInterview;

public class _BT14DetermineHeightBalanced {
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
		//n.left.right=new Node(5);
		//n.right.left=new Node(1);
		//n.right.right=new Node(30);
		n.left.left.left=new Node(123);
		System.out.println(checkHeightBalance(n));
		System.out.println();
	}
	private static boolean checkHeightBalance(Node n) {
		if(n!=null)
		{
			return Math.abs(getHeight(n.left)-getHeight(n.right))<=1 && checkHeightBalance(n.left) && checkHeightBalance(n.right);
		}
		return true;
	}
	private static int getHeight(Node n) {
		if(n!=null)
			return 1+Math.max(getHeight(n.left), getHeight(n.right));
		return 0;
	}



}

