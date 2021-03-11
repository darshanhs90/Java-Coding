package Feb2021Leetcode;

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

	public static int countUnivalSubtrees(TreeNode root) {

	}

}
