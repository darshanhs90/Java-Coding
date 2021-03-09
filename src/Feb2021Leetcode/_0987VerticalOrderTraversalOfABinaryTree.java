package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _0987VerticalOrderTraversalOfABinaryTree {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		System.out.println(verticalTraversal(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.right.left = new TreeNode(6);
		tn.right.right = new TreeNode(7);
		System.out.println(verticalTraversal(tn));
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

	static class Node {
		TreeNode tn;
		int level;

		public Node(TreeNode tn, int level) {
			this.tn = tn;
			this.level = level;
		}
	}

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (root == null)
			return output;
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			TreeMap<Integer, List<Integer>> tempMap = new TreeMap<Integer, List<Integer>>();

			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				if (tempMap.containsKey(node.level)) {
					tempMap.get(node.level).add(node.tn.val);
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(node.tn.val);
					tempMap.put(node.level, list);
				}

				if (node.tn.left != null) {
					q.offer(new Node(node.tn.left, node.level - 1));
				}

				if (node.tn.right != null) {
					q.offer(new Node(node.tn.right, node.level + 1));
				}
			}

			for (Map.Entry<Integer, List<Integer>> entry : tempMap.entrySet()) {
				Collections.sort(entry.getValue());
				if (map.containsKey(entry.getKey())) {
					map.get(entry.getKey()).addAll(entry.getValue());
				} else {
					map.put(entry.getKey(), entry.getValue());
				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}

}
