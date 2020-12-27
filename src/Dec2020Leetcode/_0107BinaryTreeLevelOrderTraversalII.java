package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0107BinaryTreeLevelOrderTraversalII {
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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(levelOrderBottom(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(2);
		tn.left.right = new TreeNode(3);
		tn.right.right = new TreeNode(3);
		System.out.println(levelOrderBottom(tn));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int height = getHeight(root);
		for (int i = height; i >= 1; i--) {
			List<Integer> list = new ArrayList<Integer>();
			getNodes(root, list, i);
			output.add(list);
		}
		return output;
	}

	public static void getNodes(TreeNode root, List<Integer> list, int currLevel) {
		if(currLevel < 1 || root == null)
			return;
		if (currLevel == 1) {
			list.add(root.val);
			return;
		}

		getNodes(root.left, list, currLevel - 1);
		getNodes(root.right, list, currLevel - 1);
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

}
