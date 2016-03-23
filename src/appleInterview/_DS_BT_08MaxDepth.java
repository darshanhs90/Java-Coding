package appleInterview;

public class _DS_BT_08MaxDepth {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		System.out.println(getMaxDepth(n));
	}
	private static int getMaxDepth(Node n) {
		if(n!=null)
		{
			int leftHeight=0,rightHeight=0;
			if(n.left!=null)
				leftHeight=getMaxDepth(n.left);
			if(n.right!=null)
				rightHeight=getMaxDepth(n.right);
			return Math.max(leftHeight, rightHeight)+1;
		}
		return 0;
	}

}

