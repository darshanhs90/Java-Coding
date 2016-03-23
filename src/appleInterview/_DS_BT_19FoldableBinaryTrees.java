package appleInterview;

public class _DS_BT_19FoldableBinaryTrees {
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
		root.right.left  = new Node(4);
		root.left.right = new Node(5);
		System.out.println(checkFoldable(root));
	}
	private static boolean checkFoldable(Node root) {
		if(root!=null){
			mirror(root.left);
			boolean res=isStructureSame(root.left,root.right);
			mirror(root.left);
			return res;
		}
		return true;
	}
	private static boolean isStructureSame(Node left, Node right) {
		if(left!=null && right!=null)
		{
			return isStructureSame(left.left, right.left) && isStructureSame(left.right, right.right);
		}
		else if(left!=null || right!=null)
			return false;
		return true;
	}
	private static void mirror(Node tn) {
		if(tn!=null)
		{	
			mirror(tn.left);
			mirror(tn.right);
			Node temp=tn.left;
			tn.left=tn.right;
			tn.right=temp;
		}

	}



}

