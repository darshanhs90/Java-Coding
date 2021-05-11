package May2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0257BinaryTreePaths {

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
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(3);
		System.out.println(binaryTreePaths(tn));

		tn = new TreeNode(1);
		System.out.println(binaryTreePaths(tn));
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> output = new ArrayList<String>();
		if (root == null)
			return output;
		dfs(root, "", output);
		return output;
	}

	public static void dfs(TreeNode root, String curr, List<String> out) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (curr.length() == 0) {
				curr += root.val;
			} else {
				curr += "->" + root.val;
			}
			out.add(curr);
			return;
		}

		if (curr.length() == 0) {
			curr += root.val;
		} else {
			curr += "->" + root.val;
		}
		dfs(root.left, curr, out);
		dfs(root.right, curr, out);
	}

}
