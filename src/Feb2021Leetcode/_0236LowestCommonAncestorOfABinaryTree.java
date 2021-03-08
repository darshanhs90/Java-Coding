package Feb2021Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0236LowestCommonAncestorOfABinaryTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(5);
		tn.left.left = new TreeNode(6);
		tn.left.right = new TreeNode(2);
		tn.left.right.left = new TreeNode(7);
		tn.left.right.right = new TreeNode(4);

		tn.right = new TreeNode(1);
		tn.right.left = new TreeNode(0);
		tn.right.right = new TreeNode(8);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.right).val);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.left.right.right).val);
		System.out.println(lowestCommonAncestor(tn, tn, tn.left).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;
		if (p == q)
			return p;

		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		parentMap.put(root, null);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = queue.poll();

				if (tn.left != null) {
					parentMap.put(tn.left, tn);
					queue.offer(tn.left);
				}

				if (tn.right != null) {
					parentMap.put(tn.right, tn);
					queue.offer(tn.right);
				}
			}
		}

		HashSet<TreeNode> nodes = new HashSet<TreeNode>();
		while (p != null) {
			nodes.add(p);
			p = parentMap.get(p);
		}

		while (q != null) {
			if (nodes.contains(q))
				return q;
			q = parentMap.get(q);
		}
		return null;
	}

}
