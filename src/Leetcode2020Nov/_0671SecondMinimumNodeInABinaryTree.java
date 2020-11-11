package Leetcode2020Nov;

public class _0671SecondMinimumNodeInABinaryTree {
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
		TreeNode tn = new TreeNode(2);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(5);
		tn.right.left = new TreeNode(5);
		tn.right.right = new TreeNode(7);
		System.out.println(findSecondMinimumValue(tn));

		tn = new TreeNode(2);
		tn.left = new TreeNode(2);
		System.out.println(findSecondMinimumValue(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		tn.right.right = new TreeNode(3);
		System.out.println(findSecondMinimumValue(tn));
	}

	static Integer min1, min2;

	public static int findSecondMinimumValue(TreeNode root) {
		min1 = null;
		min2 = null;
		preOrder(root);
		return min2 == null ? -1 : min2;
	}

	public static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (min1 == null) {
			min1 = root.val;
		} else if (min2 == null && min1 != root.val) {
			if (root.val < min1) {
				min2 = min1;
				min1 = root.val;
			} else {
				min2 = root.val;
			}
		} else if (min1 != root.val && min2 != root.val && root.val < min1) {
			min2 = min1;
			min1 = root.val;
		} else if (min1 != root.val && min2 != root.val && root.val > min1 && root.val < min2) {
			min2 = root.val;
		}
		preOrder(root.left);
		preOrder(root.right);
	}
}
