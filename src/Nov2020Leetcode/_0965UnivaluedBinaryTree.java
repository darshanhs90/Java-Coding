package Nov2020Leetcode;

public class _0965UnivaluedBinaryTree {
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
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(1);
		System.out.println(isUnivalTree(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(1);
		tn.left.left = new TreeNode(2);
		System.out.println(isUnivalTree(tn));

		tn = new TreeNode(9);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(6);
		tn.left.left = new TreeNode(9);
		tn.left.right = new TreeNode(9);
		System.out.println(isUnivalTree(tn));
	}

	public static boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return true;
		boolean isTreeValid = true;
		if (root.left != null) {
			isTreeValid = root.val == root.left.val && isUnivalTree(root.left);
		}
		if (!isTreeValid)
			return false;

		if (root.right != null) {
			isTreeValid = root.val == root.right.val && isUnivalTree(root.right);
		}
		return isTreeValid;
	}
}
