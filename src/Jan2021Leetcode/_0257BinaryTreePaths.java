package Jan2021Leetcode;

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
		List<String> lst = new ArrayList<String>();
		if (root == null)
			return lst;
		treePaths(root, "", lst);
		return lst;
	}

	public static void treePaths(TreeNode root, String currString, List<String> lst) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (currString.length() == 0)
				lst.add(root.val + "");
			else {
				lst.add(currString + "->" + root.val);
			}
			return;
		}
		String nextString = "";
		if (currString.length() == 0) {
			nextString = root.val + "";
		} else {
			nextString = currString + "->" + root.val;
		}

		treePaths(root.left, nextString, lst);
		treePaths(root.right, nextString, lst);
	}

}
