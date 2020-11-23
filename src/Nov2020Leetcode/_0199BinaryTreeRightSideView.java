package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0199BinaryTreeRightSideView {
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
		tn.right.right = new TreeNode(4);
		System.out.println(rightSideView(tn));

	}

	static boolean visited;

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> output = new ArrayList<Integer>();
		if (root == null)
			return output;
		int length = getLength(root);
		for (int i = 0; i <= length; i++) {
			visited = false;
			addNodes(root, output, i);
		}
		return output;
	}

	public static void addNodes(TreeNode root, List<Integer> output, int level) {
		if (root == null || visited)
			return;

		if (level == 0) {
			output.add(root.val);
			visited = true;
			return;
		}
		addNodes(root.right, output, level - 1);
		addNodes(root.left, output, level - 1);
	}

	public static int getLength(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getLength(root.left), getLength(root.right));
	}
}
