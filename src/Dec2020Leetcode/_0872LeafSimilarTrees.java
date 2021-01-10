package Dec2020Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0872LeafSimilarTrees {
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
		TreeNode tn1 = new TreeNode(3);
		tn1.left = new TreeNode(5);
		tn1.left.left = new TreeNode(6);
		tn1.left.right = new TreeNode(2);
		tn1.left.right.left = new TreeNode(7);
		tn1.left.right.right = new TreeNode(4);
		tn1.right = new TreeNode(1);
		tn1.right.left = new TreeNode(9);
		tn1.right.right = new TreeNode(8);

		TreeNode tn2 = new TreeNode(3);
		tn2.left = new TreeNode(5);
		tn2.left.left = new TreeNode(6);
		tn2.left.right = new TreeNode(7);
		tn2.right = new TreeNode(1);
		tn2.right.left = new TreeNode(4);
		tn2.right.right = new TreeNode(2);
		tn2.right.right.left = new TreeNode(9);
		tn2.right.right.right = new TreeNode(8);

		System.out.println(leafSimilar(tn1, tn2));

		tn1 = new TreeNode(1);
		tn2 = new TreeNode(2);
		System.out.println(leafSimilar(tn1, tn2));
	}

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		preOrder(root1, q1);
		preOrder(root2, q2);
		while (!q1.isEmpty() && !q2.isEmpty()) {
			if (q1.peek() != q2.peek())
				return false;
			q1.poll();
			q2.poll();
		}
		return q1.size() == q2.size();
	}

	public static void preOrder(TreeNode root, Queue<Integer> q) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			q.offer(root.val);
		}
		preOrder(root.left, q);
		preOrder(root.right, q);
	}

}
