package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0637AverageOfLevelsInBinaryTree {
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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(averageOfLevels(tn));
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		if (root == null) {
			return new ArrayList<Double>();
		}
		List<Long> sum = new ArrayList<Long>();
		List<Long> count = new ArrayList<Long>();
		preOrder(root, sum, count, 0);

		List<Double> out = new ArrayList<Double>();
		for (int i = 0; i < sum.size(); i++) {
			out.add((double) sum.get(i) / count.get(i));
		}
		return out;
	}

	public static void preOrder(TreeNode root, List<Long> sum, List<Long> count, int level) {
		if (root == null) {
			return;
		}
		if (sum.size() >= level + 1) {
			sum.set(level, sum.get(level) + root.val);
			count.set(level, count.get(level) + 1);
		} else {
			sum.add((long) root.val);
			count.add((long) 1);
		}

		preOrder(root.left, sum, count, level + 1);
		preOrder(root.right, sum, count, level + 1);
	}
}
