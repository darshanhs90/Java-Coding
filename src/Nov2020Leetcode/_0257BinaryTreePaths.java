package Nov2020Leetcode;

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
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		preOrder(root, list, "");
		return list;
	}

	public static void preOrder(TreeNode root, List<String> list, String str) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (str.length() > 0) {
				list.add(str + "->" + root.val);
			} else {
				list.add(root.val + "");
			}
			return;
		}
		if (str.length() > 0) {
			str = str + "->" + root.val;
		} else {
			str = root.val + "";
		}
		preOrder(root.left, list, str);
		preOrder(root.right, list, str);
	}
}
