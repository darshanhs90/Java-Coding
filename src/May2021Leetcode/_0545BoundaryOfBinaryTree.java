package May2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		List<Integer> output = new ArrayList<Integer>();
		if (root == null)
			return output;
		output.add(root.val);
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		addLeftNodes(root.left, output, set);
		addLeftLeaves(root.left, output, set);
		addRightLeaves(root.right, output, set);
		addRightNodes(root.right, output, set);
		return output;
	}

	public static void addLeftNodes(TreeNode root, List<Integer> list, HashSet<TreeNode> set) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			boolean added = false;
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (!added) {
					if (!set.contains(tn)) {
						list.add(tn.val);
						set.add(tn);
					}
					added = true;
				}

				if (tn.left != null) {
					q.offer(tn.left);
				}

				if (tn.right != null) {
					q.offer(tn.right);
				}
			}
		}
	}

	public static void addRightLeaves(TreeNode root, List<Integer> list, HashSet<TreeNode> set) {
		if (root == null)
			return;
		addRightLeaves(root.left, list, set);
		if (root.left == null && root.right == null) {
			if (!set.contains(root)) {
				list.add(root.val);
				set.add(root);
			}
		}
		addRightLeaves(root.right, list, set);
	}

	public static void addLeftLeaves(TreeNode root, List<Integer> list, HashSet<TreeNode> set) {
		if (root == null)
			return;
		addLeftLeaves(root.left, list, set);
		if (root.left == null && root.right == null) {
			if (!set.contains(root)) {
				list.add(root.val);
				set.add(root);
			}
		}
		addLeftLeaves(root.right, list, set);
	}

	public static void addRightNodes(TreeNode root, List<Integer> list, HashSet<TreeNode> set) {
		if (root == null)
			return;
		List<Integer> tempList = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			boolean added = false;
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (!added) {
					if (!set.contains(tn)) {
						tempList.add(tn.val);
						set.add(tn);
					}
					added = true;
				}
				if (tn.right != null) {
					q.offer(tn.right);
				}

				if (tn.left != null) {
					q.offer(tn.left);
				}
			}
		}
		Collections.reverse(tempList);
		list.addAll(tempList);
	}

}
