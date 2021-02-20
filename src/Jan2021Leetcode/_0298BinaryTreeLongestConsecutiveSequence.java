package Jan2021Leetcode;

public class _0298BinaryTreeLongestConsecutiveSequence {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		System.out.println(longestConsecutive(root));
	}

	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		preOrder(root.left);
		System.out.print(root.val + "->");
		preOrder(root.right);
	}

	static int maxLength;

	public static int longestConsecutive(TreeNode root) {
		maxLength = 1;
		if (root == null)
			return 0;
		maxLengthCheck(root.left, root, 1);
		maxLengthCheck(root.right, root, 1);
		return maxLength;
	}

	public static void maxLengthCheck(TreeNode currRoot, TreeNode root, int currVal) {
		if (currRoot == null)
			return;
		if (currRoot.val == root.val + 1)
			currVal++;
		else {
			currVal = 1;
		}
		maxLength = Math.max(maxLength, currVal);
		maxLengthCheck(currRoot.left, currRoot, currVal);
		maxLengthCheck(currRoot.right, currRoot, currVal);
	}

}
