package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0637AverageOfLevelsInBinaryTree {
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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(averageOfLevels(tn));
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<Double>();
		if (root == null)
			return list;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			long sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode poll = q.poll();
				if (poll.left != null)
					q.offer(poll.left);

				if (poll.right != null)
					q.offer(poll.right);

				sum += poll.val;
			}
			list.add(sum / (double) size);
		}
		return list;
	}

}
