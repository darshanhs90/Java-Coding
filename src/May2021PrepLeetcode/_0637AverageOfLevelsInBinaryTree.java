package May2021PrepLeetcode;

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
		List<Double> output = new ArrayList<Double>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root == null)
			return output;
		q.offer(root);
		while (!q.isEmpty()) {
			long sum = 0;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				sum += tn.val;
				if (tn.left != null) {
					q.offer(tn.left);
				}

				if (tn.right != null) {
					q.offer(tn.right);
				}
			}
			output.add(sum / (double) size);
		}
		return output;
	}

}
