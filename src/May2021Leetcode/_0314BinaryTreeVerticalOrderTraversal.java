package May2021Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _0314BinaryTreeVerticalOrderTraversal {

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
		System.out.println(verticalOrder(tn));

		tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(8);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(0);
		tn.right.left = new TreeNode(1);
		tn.right.right = new TreeNode(7);
		System.out.println(verticalOrder(tn));
	}

	static class Pair {
		TreeNode node;
		int level;

		public Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (root == null)
			return output;
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				TreeNode tn = pair.node;
				int currLevel = pair.level;
				if (!map.containsKey(currLevel)) {
					map.put(currLevel, new ArrayList<Integer>());
				}
				map.get(currLevel).add(tn.val);

				if (tn.left != null) {
					q.offer(new Pair(tn.left, currLevel - 1));
				}

				if (tn.right != null) {
					q.offer(new Pair(tn.right, currLevel + 1));
				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}
}
