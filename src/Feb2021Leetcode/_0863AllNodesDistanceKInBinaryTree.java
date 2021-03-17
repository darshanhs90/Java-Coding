package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0863AllNodesDistanceKInBinaryTree {
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
		tn.right = new TreeNode(1);
		tn.left.left = new TreeNode(6);
		tn.left.right = new TreeNode(2);
		tn.left.right.left = new TreeNode(7);
		tn.left.right.right = new TreeNode(4);

		tn.right.left = new TreeNode(0);
		tn.right.right = new TreeNode(8);
		System.out.println(distanceK(tn, tn.left, 2));
	}

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> out = new ArrayList<Integer>();
		if (root == null)
			return out;
		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		parentMap.put(root, null);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();

				if (tn.left != null) {
					parentMap.put(tn.left, tn);
					q.offer(tn.left);
				}

				if (tn.right != null) {
					parentMap.put(tn.right, tn);
					q.offer(tn.right);
				}
			}
		}
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		while (K >= 1 && target != null) {
			addChildNodes(target, K, out, visited);
			target = parentMap.get(target);
			K--;
		}
		if (target != null && !out.contains(target.val))
			out.add(target.val);
		return out;
	}

	public static void addChildNodes(TreeNode root, int K, List<Integer> list, HashSet<TreeNode> visited) {
		if (visited.contains(root) || K < 0)
			return;
		if (K == 0) {
			list.add(root.val);
			return;
		}

		visited.add(root);
		if (root.left != null)
			addChildNodes(root.left, K - 1, list, visited);

		if (root.right != null)
			addChildNodes(root.right, K - 1, list, visited);
	}

}
