package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _1110DeleteNodesAndReturnForest {

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
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.right.left = new TreeNode(6);
		tn.right.right = new TreeNode(7);

		System.out.println(delNodes(tn, new int[] { 3, 5 }).size());

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		System.out.println(delNodes(tn, new int[] { 3 }).size());
	}

	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> forestNodes = new ArrayList<TreeNode>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < to_delete.length; i++) {
			set.add(to_delete[i]);
		}

		dfs(root, set, forestNodes);
		if (!set.contains(root.val)) {
			forestNodes.add(root);
		}
		return forestNodes;
	}

	public static TreeNode dfs(TreeNode root, HashSet<Integer> set, List<TreeNode> forest) {
		if (root == null)
			return null;
		root.left = dfs(root.left, set, forest);
		root.right = dfs(root.right, set, forest);

		if (set.contains(root.val)) {
			if (root.left != null)
				forest.add(root.left);
			if (root.right != null)
				forest.add(root.right);
			return null;
		}
		return root;
	}
}
