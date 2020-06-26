package PracticeLeetCode;

public class _226InvertBinaryTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(4);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(3);
		tn.right = new TreeNode(7);
		tn.right.left = new TreeNode(6);
		tn.right.right = new TreeNode(9);
		preOrder(tn);
		System.out.println();
		tn = invertTree(tn);

		preOrder(tn);
	}

	public static TreeNode invertTree(TreeNode root) {
		if(root == null)
		{
			return null;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.right);
		invertTree(root.left);
		return root;
	}

	public static void preOrder(TreeNode root) {
		if(root == null)
		{
			return;
		}
		System.out.print(root.val+"-");
		preOrder(root.left);
		preOrder(root.right);
	}

}
