package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0652FindDuplicateSubtrees {
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
		tn.left.left = new TreeNode(4);
		tn.right = new TreeNode(3);
		tn.right.right = new TreeNode(4);
		tn.right.left = new TreeNode(2);
		tn.right.left.left = new TreeNode(4);
		System.out.println(findDuplicateSubtrees(tn));
	}

	static List<TreeNode> out;
	static HashMap<String, Integer> countMap;

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		out = new ArrayList<TreeNode>();
		countMap = new HashMap<String, Integer>();
		if (root == null)
			return out;
		dfs(root);
		return out;
	}

	public static String dfs(TreeNode root) {
		if (root == null)
			return "#";
		String str = root.val + "," + dfs(root.left) + "," + dfs(root.right);
		countMap.compute(str, (k, v) -> v == null ? 1 : v + 1);
		if (countMap.get(str) == 2) {
			out.add(root);
		}
		return str;
	}
}
