package May2021GoogLeetcode;

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
		if (root == null || root == p || root == q)
			return root;
		if (p == q)
			return p;

		HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

		map.put(root, null);
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.offer(root);
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = qu.poll();

				if (tn.left != null) {
					qu.offer(tn.left);
					map.put(tn.left, tn);
				}

				if (tn.right != null) {
					qu.offer(tn.right);
					map.put(tn.right, tn);
				}
			}
		}

		HashSet<TreeNode> parents = new HashSet<TreeNode>();

		while (p != null) {
			parents.add(p);
			p = map.get(p);
		}

		while (q != null) {
			if (parents.contains(q))
				return q;
			q = map.get(q);
		}

		return null;
	}

}
