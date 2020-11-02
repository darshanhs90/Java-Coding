package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0107BinaryTreeLevelOrderTraversalII {
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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(levelOrderBottom(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(2);
		tn.left.right = new TreeNode(3);
		tn.right.right = new TreeNode(3);
		System.out.println(levelOrderBottom(tn));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int maxDepth = getMaxDepth(root);
		for (int i = maxDepth; i >= 1; i--) {
			List<Integer> levelList = new ArrayList<Integer>();
			addNodesToList(root, i, 1, levelList);
			output.add(levelList);
		}
		return output;
	}

	public static void addNodesToList(TreeNode root, int depth, int currDepth, List<Integer> list) {
		if (root == null)
			return;
		if (depth == currDepth) {
			list.add(root.val);
			return;
		}
		addNodesToList(root.left, depth, currDepth + 1, list);
		addNodesToList(root.right, depth, currDepth + 1, list);
	}

	public static int getMaxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
	}
}
