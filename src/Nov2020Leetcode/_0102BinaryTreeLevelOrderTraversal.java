package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0102BinaryTreeLevelOrderTraversal {
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
		System.out.println(levelOrder(tn));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		preOrder(0, root, out);
		return out;
	}

	public static void preOrder(int level, TreeNode root, List<List<Integer>> out) {
		if (root == null)
			return;
		List<Integer> list;
		if (out.size() >= level + 1) {
			list = out.get(level);
			list.add(root.val);
		} else {
			list = new ArrayList<Integer>();
			list.add(root.val);
			out.add(list);
		}

		preOrder(level + 1, root.left, out);
		preOrder(level + 1, root.right, out);
	}

}
