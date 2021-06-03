package May2021GoogLeetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0958CheckCompletenessOfABinaryTree {
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
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.right.left = new TreeNode(6);
		System.out.println(isCompleteTree(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.right.right = new TreeNode(6);
		System.out.println(isCompleteTree(tn));
	}

	public static boolean isCompleteTree(TreeNode root) {
		if (root == null)
			return true;
		boolean nullFound = false;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();

				if (tn.left != null) {
					if (nullFound)
						return false;
					q.offer(tn.left);
				} else {
					nullFound = true;
				}

				if (tn.right != null) {
					if (nullFound)
						return false;
					q.offer(tn.right);
				} else {
					nullFound = true;
				}
			}
		}
		return true;
	}

}
