package FacebookPrep;

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
		preOrder(root, output, "");
		return output;
	}

	public static void preOrder(TreeNode root, List<String> output, String currString) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (currString.length() == 0)
				output.add(root.val + "");
			else

				output.add(currString + "->" + root.val);
			return;
		}

		String newString = currString.length() == 0 ? root.val + "" : currString + "->" + root.val;
		preOrder(root.left, output, newString);
		preOrder(root.right, output, newString);
	}

}
