package Dec2020Leetcode;

public class _0250CountUnivalueSubtrees {

	public static class TreeNode {
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
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(1);
		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(countUnivalSubtrees(tn));
	}

	static int count;

	public static int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		count = 0;
		countNodes(root);
		return count;
	}

	public static boolean countNodes(TreeNode root) {
		if (root.left == null && root.right == null) {
			count++;
			return true;
		}

		boolean isUnival = true;
		if (root.left != null) {
			isUnival = countNodes(root.left) && isUnival && root.val == root.left.val;
		}
		if (root.right != null) {
			isUnival = countNodes(root.right) && isUnival && root.val == root.right.val;
		}

		if (!isUnival)
			return false;
		count++;
		return true;
	}

}
