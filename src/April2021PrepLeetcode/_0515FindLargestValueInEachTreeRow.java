package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0515FindLargestValueInEachTreeRow {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(2);

		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(3);
		tn.right.right = new TreeNode(9);
		System.out.println(largestValues(tn));
	}

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

	public static List<Integer> largestValues(TreeNode root) {
		List<Integer> output = new ArrayList<Integer>();
		if (root == null)
			return output;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			long maxVal = Long.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				maxVal = Math.max(maxVal, tn.val);

				if (tn.left != null) {
					q.offer(tn.left);
				}

				if (tn.right != null) {
					q.offer(tn.right);
				}
			}
			output.add((int) maxVal);
		}
		return output;
	}

}
