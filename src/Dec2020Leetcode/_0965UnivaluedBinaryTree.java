package Dec2020Leetcode;

import java.util.HashSet;

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
			return false;
		HashSet<Integer> set = new HashSet<Integer>();
		preOrder(root, set);
		return set.size() == 1;
	}

	public static void preOrder(TreeNode root, HashSet<Integer> set) {
		if (root == null || set.size() > 2)
			return;
		preOrder(root.left, set);
		set.add(root.val);
		preOrder(root.right, set);
	}

}
