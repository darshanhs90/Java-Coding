package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.List;

public class _031BinaryTreeRightSideView {
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

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		System.out.println(rightSideView(tn));
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		rightSideView(root, 0, list);
		return list;
	}

	public static void rightSideView(TreeNode root, int level, List<Integer> list) {
		if (root == null)
			return;
		if (list.size() < level + 1)
			list.add(root.val);
		rightSideView(root.right, level + 1, list);
		rightSideView(root.left, level + 1, list);
	}
}
