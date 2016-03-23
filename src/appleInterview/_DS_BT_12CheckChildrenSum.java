package appleInterview;

public class _DS_BT_12CheckChildrenSum {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(10);
		n.left=new Node(8);
		n.right=new Node(2);
		n.left.left=new Node(3);
		n.left.right=new Node(5);
		n.right.left=new Node(2);
		System.out.println(checkSumProperty(n));
	}
	private static boolean checkSumProperty(Node n) {
		if(n!=null)
		{	
			if(n.left==null && n.right==null)
				return true;
			int leftVal=0,rightVal=0;
			if(n.left!=null)
				leftVal=n.left.value;
			if(n.right!=null)
				rightVal=n.right.value;
			return n.value==(leftVal+rightVal) && checkSumProperty(n.left) && checkSumProperty(n.right);
		}
		return true;
	}

}

