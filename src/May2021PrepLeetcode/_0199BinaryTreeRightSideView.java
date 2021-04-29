package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> output = new ArrayList<Integer>();
		if (root == null)
			return output;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			boolean added = false;
			for (int i = 0; i < size; i++) {
				TreeNode poll = q.poll();
				if (!added) {
					output.add(poll.val);
					added = true;
				}

				if (poll.right != null) {
					q.offer(poll.right);
				}

				if (poll.left != null) {
					q.offer(poll.left);
				}
			}
		}
		return output;
	}
}
