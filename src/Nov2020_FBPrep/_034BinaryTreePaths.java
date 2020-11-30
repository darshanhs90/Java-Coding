package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.List;

public class _034BinaryTreePaths {

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
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(3);
		System.out.println(binaryTreePaths(tn));
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		preOrder("", root, list);
		return list;
	}

	public static void preOrder(String currString, TreeNode root, List<String> list) {
		if (root == null)
			return;
		else if (root.left == null && root.right == null) {
			currString += root.val;
			list.add(currString);
			return;
		}
		currString += root.val + "->";
		preOrder(currString, root.left, list);
		preOrder(currString, root.right, list);
	}
}
