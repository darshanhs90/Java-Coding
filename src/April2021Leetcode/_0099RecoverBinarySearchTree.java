package April2021Leetcode;

public class _0099RecoverBinarySearchTree {
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
		tn.left = new TreeNode(3);
		tn.left.right = new TreeNode(2);
		preOrder(tn);
		System.out.println();
		recoverTree(tn);
		preOrder(tn);
		System.out.println();
	}

	public static void preOrder(TreeNode root) {
		if (root != null) {
			preOrder(root.left);
			System.out.print(root.val + "/");
			preOrder(root.right);
		}
	}

	public static void recoverTree(TreeNode root) {

	}
}
