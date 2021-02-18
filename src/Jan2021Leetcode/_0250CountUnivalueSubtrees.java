package Jan2021Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0250CountUnivalueSubtrees {

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
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(1);
		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(countUnivalSubtrees(tn));
	}

	public static int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (isUniValTree(tn, tn.val))
					count++;

				if (tn.left != null)
					q.offer(tn.left);

				if (tn.right != null)
					q.offer(tn.right);
			}
		}
		return count;
	}

	public static boolean isUniValTree(TreeNode root, int val) {
		if (root == null)
			return true;
		if (root.val != val)
			return false;
		return isUniValTree(root.left, val) && isUniValTree(root.right, val);
	}

}
