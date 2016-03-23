package appleInterview;

public class _DS_BT_14DiameterOfBinaryTree {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(50);
		n.left=new Node(7);
		n.right=new Node(2);
		n.left.left=new Node(3);
		n.left.right=new Node(5);
		n.right.left=new Node(1);
		n.right.right=new Node(30);
		System.out.println(findDiameter(n));
	}
	private static int findDiameter(Node n) {
		if(n!=null)
		{
			int leftDiameter=findDiameter(n.left);
			int rightDiameter=findDiameter(n.right);
			int leftHeight=getHeight(n.left);
			int rightHeight=getHeight(n.left);
			return Math.max(leftHeight+rightHeight+1,Math.max(leftDiameter, rightDiameter));	
		}
		return 0;
	}
	private static int getHeight(Node tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		}
		return 0;
	}




}

