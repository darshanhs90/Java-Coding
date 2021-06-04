package June2021GoogLeetcode;

public class _0298BinaryTreeLongestConsecutiveSequence {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		tn.right.right = new TreeNode(4);
		tn.right.right.right = new TreeNode(5);
		System.out.println(longestConsecutive(tn));

		tn = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		tn.right.left.left = new TreeNode(1);
		System.out.println(longestConsecutive(tn));

	}

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

	static int max;

	public static int longestConsecutive(TreeNode root) {
		max = 0;
		if (root == null)
			return 0;
		helper(root, root.val, 1);
		return max;
	}

	public static void helper(TreeNode root, int currVal, int currLen) {
		if (root == null)
			return;

		int newLen = root.val == currVal + 1 ? currLen + 1 : 1;
		max = Math.max(max, newLen);
		helper(root.left, root.val, newLen);
		helper(root.right, root.val, newLen);
	}

}
