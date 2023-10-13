package Oct2023Leetcode;

public class _0669TrimABinarySearchTree {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(0);
		tn.right = new TreeNode(2);
		tn = trimBST(tn, 1, 2);
		preOrder(tn);
		System.out.println();

		tn = new TreeNode(3);
		tn.left = new TreeNode(0);
		tn.right = new TreeNode(4);
		tn.left.right = new TreeNode(2);
		tn.left.right.left = new TreeNode(1);
		tn = trimBST(tn, 1, 3);
		preOrder(tn);
		System.out.println();
	}

	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		preOrder(root.left);
		System.out.print(root.val + "/");
		preOrder(root.right);
	}

	public static TreeNode trimBST(TreeNode root, int low, int high) {
		
	}

}
