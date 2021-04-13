package April2021Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0235LowestCommonAncestorOfABinarySearchTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(6);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(0);
		tn.left.right = new TreeNode(4);
		tn.left.right.left = new TreeNode(3);
		tn.left.right.right = new TreeNode(5);

		tn.right = new TreeNode(8);
		tn.right.left = new TreeNode(7);
		tn.right.right = new TreeNode(9);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.right).val);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.left.right).val);
		System.out.println(lowestCommonAncestor(tn, tn, tn.left).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		if (p == q)
			return p;
		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		parentMap.put(root, null);
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.offer(root);
		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = qu.poll();

				if (tn.left != null) {
					qu.offer(tn.left);
					parentMap.put(tn.left, tn);
				}

				if (tn.right != null) {
					qu.offer(tn.right);
					parentMap.put(tn.right, tn);
				}
			}
		}

		HashSet<TreeNode> pSet = new HashSet<TreeNode>();
		while (p != null) {
			pSet.add(p);
			p = parentMap.get(p);
		}

		while (q != null) {
			if (pSet.contains(q))
				return q;
			q = parentMap.get(q);
		}

		return null;
	}

}
