package Dec2020Leetcode;

import java.util.HashSet;

public class _0653TwoSumIVInputIsABST {
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
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(6);
		tn.left.left = new TreeNode(2);
		tn.left.right = new TreeNode(4);
		tn.right.right = new TreeNode(7);
		System.out.println(findTarget(tn, 9));
		System.out.println(findTarget(tn, 28));

		tn = new TreeNode(2);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(3);
		System.out.println(findTarget(tn, 4));
		System.out.println(findTarget(tn, 1));
		System.out.println(findTarget(tn, 3));
	}

	public static boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		return preOrder(root, k, set);
	}

	public static boolean preOrder(TreeNode root, int k, HashSet<Integer> set) {
		if (root == null)
			return false;
		boolean output = preOrder(root.left, k, set);
		if (!output) {
			output = set.contains(k - root.val);
			set.add(root.val);
		}
		if (!output) {
			output = preOrder(root.right, k, set);
		}
		return output;
	}

}
