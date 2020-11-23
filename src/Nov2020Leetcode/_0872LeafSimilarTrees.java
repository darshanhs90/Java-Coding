package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0872LeafSimilarTrees {
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
		TreeNode tn1 = new TreeNode(3);
		tn1.left = new TreeNode(5);
		tn1.left.left = new TreeNode(6);
		tn1.left.right = new TreeNode(2);
		tn1.left.right.left = new TreeNode(7);
		tn1.left.right.right = new TreeNode(4);
		tn1.right = new TreeNode(1);
		tn1.right.left = new TreeNode(9);
		tn1.right.right = new TreeNode(8);

		TreeNode tn2 = new TreeNode(3);
		tn2.left = new TreeNode(5);
		tn2.left.left = new TreeNode(6);
		tn2.left.right = new TreeNode(7);
		tn2.right = new TreeNode(1);
		tn2.right.left = new TreeNode(4);
		tn2.right.right = new TreeNode(2);
		tn2.right.right.left = new TreeNode(9);
		tn2.right.right.right = new TreeNode(8);

		System.out.println(leafSimilar(tn1, tn2));

		tn1 = new TreeNode(1);
		tn2 = new TreeNode(2);
		System.out.println(leafSimilar(tn1, tn2));
	}

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<Integer>();
		getLeafNodes(root1, list1);
		List<Integer> list2 = new ArrayList<Integer>();
		getLeafNodes(root2, list2);
		if (list1.size() != list2.size())
			return false;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i))
				return false;
		}
		return true;
	}

	public static void getLeafNodes(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		}
		getLeafNodes(root.left, list);
		getLeafNodes(root.right, list);
	}
}
