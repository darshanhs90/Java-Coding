package May2021PrepLeetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _0993CousinsInBinaryTree {
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
		System.out.println(isCousins(tn, 4, 3));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		tn.right.right = new TreeNode(5);
		System.out.println(isCousins(tn, 5, 4));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		System.out.println(isCousins(tn, 2, 3));
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;
		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		TreeNode xNode = null, yNode = null;
		parentMap.put(root, null);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (tn.val == x) {
					xNode = tn;
				}

				if (tn.val == y) {
					yNode = tn;
				}

				if (tn.left != null) {
					q.offer(tn.left);
					parentMap.put(tn.left, tn);
				}

				if (tn.right != null) {
					q.offer(tn.right);
					parentMap.put(tn.right, tn);
				}
			}

			if (xNode != null && yNode != null) {
				if (parentMap.get(xNode) != parentMap.get(yNode))
					return true;
				return false;
			} else if (xNode != null || yNode != null)
				return false;
		}
		return false;
	}

}
