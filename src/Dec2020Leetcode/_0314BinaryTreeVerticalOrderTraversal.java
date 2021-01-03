package Dec2020Leetcode;

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

	static class NodeWrapper {
		TreeNode tn;
		int level;

		public NodeWrapper(TreeNode tn, int level) {
			this.tn = tn;
			this.level = level;
		}
	}

	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		Queue<NodeWrapper> q = new LinkedList<NodeWrapper>();
		if (root == null)
			return list;
		q.offer(new NodeWrapper(root, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				NodeWrapper nw = q.poll();
				if (map.containsKey(nw.level)) {
					map.get(nw.level).add(nw.tn.val);
				} else {
					List<Integer> lst = new ArrayList<Integer>();
					lst.add(nw.tn.val);
					map.put(nw.level, lst);
				}

				if (nw.tn.left != null) {
					q.offer(new NodeWrapper(nw.tn.left, nw.level - 1));
				}

				if (nw.tn.right != null) {
					q.offer(new NodeWrapper(nw.tn.right, nw.level + 1));
				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
}
