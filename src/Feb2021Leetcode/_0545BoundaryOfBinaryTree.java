package Feb2021Leetcode;

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
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		output.add(root.val);
		set.add(root);
		if (root.left != null)
			output.addAll(addLeftNodes(root.left, set));
		output.addAll(addLeafNodes(root, set));
		if (root.right != null)
			output.addAll(addRightNodes(root.right, set));
		return output;
	}

	public static List<Integer> addLeafNodes(TreeNode root, HashSet<TreeNode> visited) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		List<Integer> output = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (tn.left == null && tn.right == null) {
					if (!visited.contains(tn)) {
						output.add(tn.val);
					}
					visited.add(tn);
				}
				if (tn.left != null) {
					q.offer(tn.left);
				}

				if (tn.right != null) {
					q.offer(tn.right);
				}
			}
		}
		return output;
	}

	public static List<Integer> addRightNodes(TreeNode root, HashSet<TreeNode> visited) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		List<Integer> output = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int size = q.size();
			boolean added = false;
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (!added) {
					if (!visited.contains(tn)) {
						output.add(tn.val);
					}
					visited.add(tn);
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
		Collections.reverse(output);
		return output;
	}

	public static List<Integer> addLeftNodes(TreeNode root, HashSet<TreeNode> visited) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		List<Integer> output = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int size = q.size();
			boolean added = false;
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (!added) {
					if (!visited.contains(tn)) {
						output.add(tn.val);
					}
					visited.add(tn);
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
		return output;
	}

}
