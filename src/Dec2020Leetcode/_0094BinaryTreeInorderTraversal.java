package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0094BinaryTreeInorderTraversal {
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
		tn.right = new TreeNode(2);
		tn.right.left = new TreeNode(3);
		System.out.println(inorderTraversal(tn));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> output = new ArrayList<Integer>();
		inorder(root, output);
		return output;
	}

	public static void inorder(TreeNode root, List<Integer> output) {
		if (root == null)
			return;
		inorder(root.left, output);
		output.add(root.val);
		inorder(root.right, output);
	}

}
