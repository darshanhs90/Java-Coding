package May2021GoogLeetcode;

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

	public static void helper(TreeNode root, int parentVal, int count) {
		if (root == null)
			return;

		if (root.val == parentVal + 1) {
			count += 1;
		} else {
			count = 1;
		}

		max = Math.max(max, count);
		helper(root.left, root.val, count);
		helper(root.right, root.val, count);
	}

}
