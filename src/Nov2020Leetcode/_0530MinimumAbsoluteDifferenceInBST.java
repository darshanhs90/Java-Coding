package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0530MinimumAbsoluteDifferenceInBST {
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
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		System.out.println(getMinimumDifference(tn));
	}

	static List<Integer> list = new ArrayList<Integer>();

	public static int getMinimumDifference(TreeNode root) {
		if (root == null)
			return 0;
		list = new ArrayList<Integer>();
		populateList(root, list);
		System.out.println(list);
		int minDifference = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			minDifference = Math.min(minDifference, Math.abs(list.get(i) - list.get(i - 1)));
		}
		return list.size() > 0 ? minDifference : 0;
	}

	public static void populateList(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		populateList(root.left, list);
		list.add(root.val);
		populateList(root.right, list);
	}
}
