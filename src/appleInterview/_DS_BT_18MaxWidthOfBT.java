package appleInterview;

public class _DS_BT_18MaxWidthOfBT {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left        = new Node(2);
		root.right       = new Node(3);
		root.left.left  = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(8);    
		root.right.right.left  = new Node(6);    
		root.right.right.right  = new Node(7);
		System.out.println(maxWidth(root));
	}
	private static int maxWidth(Node root) {
		int height=getHeight(root);
		int width=0;
		for (int i = 0; i < height; i++) {
			width=Math.max(width, getWidth(root,i));
		}
		return width;
	}
	private static int getWidth(Node tn, int level) {
		if(tn!=null)
		{
			if(level==0)
				return 1;
			return getWidth(tn.left, level-1)+getWidth(tn.right, level-1);
		}
		return 0;
	}
	private static int getHeight(Node root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}



}

