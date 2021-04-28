package May2021PrepLeetcode;

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

	static class Node {
		TreeNode node;
		int level;

		public Node(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public static List<List<Integer>> verticalOrder(TreeNode root) {
		TreeMap<Integer, List<Integer>> tMap = new TreeMap<Integer, List<Integer>>();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (root == null)
			return output;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				TreeNode tn = node.node;
				int level = node.level;

				if (!tMap.containsKey(level)) {
					tMap.put(level, new ArrayList<Integer>());
				}

				tMap.get(level).add(tn.val);

				if (tn.left != null) {
					q.offer(new Node(tn.left, level - 1));
				}

				if (tn.right != null) {
					q.offer(new Node(tn.right, level + 1));
				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : tMap.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}
}
