package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _041BinaryTreeVerticalOrderTraversal {
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
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (root == null)
			return output;
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(root, 0));
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (map.containsKey(n.level)) {
				map.get(n.level).add(n.node.val);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(n.node.val);
				map.put(n.level, list);
			}
			if (n.node.left != null)
				q.offer(new Node(n.node.left, n.level - 1));
			if (n.node.right != null)
				q.offer(new Node(n.node.right, n.level + 1));
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}

		return output;
	}

}
