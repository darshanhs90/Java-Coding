package Jan2021Leetcode;

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
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		output.add(root.val);
		visited.add(root);
		leftBoundary(root.left, visited, output);
		leaves(root, visited, output);
		List<Integer> tempList = new ArrayList<Integer>();
		rightBoundary(root.right, visited, tempList);
		Collections.reverse(tempList);
		output.addAll(tempList);
		return output;
	}

	public static void leftBoundary(TreeNode root, HashSet<TreeNode> visited, List<Integer> list) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root != null)
			q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			boolean added = false;
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (!added) {
					if (!visited.contains(tn)) {
						list.add(tn.val);
						visited.add(tn);
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

	public static void rightBoundary(TreeNode root, HashSet<TreeNode> visited, List<Integer> list) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root != null)
			q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			boolean added = false;
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (!added) {
					if (!visited.contains(tn)) {
						list.add(tn.val);
						visited.add(tn);
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
	}

	public static void leaves(TreeNode root, HashSet<TreeNode> visited, List<Integer> list) {
		if (root == null)
			return;
		leaves(root.left, visited, list);
		if (root.left == null && root.right == null) {
			if (!visited.contains(root)) {
				list.add(root.val);
				visited.add(root);
			}
		}
		leaves(root.right, visited, list);
	}

}
