package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class _0545BoundaryOfBinaryTree {

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
		tn.right.right = new TreeNode(4);
		System.out.println(boundaryOfBinaryTree(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.left.right.left = new TreeNode(7);
		tn.left.right.right = new TreeNode(8);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(6);
		tn.right.left.left = new TreeNode(9);
		tn.right.left.right = new TreeNode(10);
		System.out.println(boundaryOfBinaryTree(tn));
	}

	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		list.add(root.val);
		set.add(root);
		leftSideView(root.left, list, set);
		populateLeaves(root, list, set);

		List<Integer> tempList = new ArrayList<Integer>();
		rightSideView(root.right, tempList, set);
		Collections.reverse(tempList);
		list.addAll(tempList);
		return list;
	}

	public static void leftSideView(TreeNode root, List<Integer> list, HashSet<TreeNode> set) {
		if (root == null || (root.left == null && root.right == null))
			return;
		if (!set.contains(root)) {
			list.add(root.val);
			set.add(root);
		}

		if (root.left == null)
			leftSideView(root.right, list, set);
		else
			leftSideView(root.left, list, set);
	}

	public static void populateLeaves(TreeNode root, List<Integer> list, HashSet<TreeNode> set) {
		if (root == null)
			return;
		populateLeaves(root.left, list, set);
		if (root.left == null && root.right == null) {
			if (!set.contains(root)) {
				list.add(root.val);
				set.add(root);
			}
			return;
		}
		populateLeaves(root.right, list, set);
	}

	public static void rightSideView(TreeNode root, List<Integer> list, HashSet<TreeNode> set) {
		if (root == null || (root.left == null && root.right == null))
			return;
		if (!set.contains(root)) {
			list.add(root.val);
			set.add(root);
		}

		if (root.right == null)
			rightSideView(root.left, list, set);
		else
			rightSideView(root.right, list, set);
	}

}
