package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

	static class TreeNodeLevel {
		TreeNode tn;
		int level;

		public TreeNodeLevel(TreeNode tn, int level) {
			this.tn = tn;
			this.level = level;
		}
	}

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Queue<TreeNodeLevel> q = new LinkedList<TreeNodeLevel>();
		if (root != null)
			q.offer(new TreeNodeLevel(root, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			HashMap<Integer, List<Integer>> mapLocal = new HashMap<Integer, List<Integer>>();
			for (int i = 0; i < size; i++) {
				TreeNodeLevel tnl = q.poll();
				if (mapLocal.containsKey(tnl.level)) {
					mapLocal.get(tnl.level).add(tnl.tn.val);
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(tnl.tn.val);
					mapLocal.put(tnl.level, list);
				}

				if (tnl.tn.left != null) {
					q.offer(new TreeNodeLevel(tnl.tn.left, tnl.level - 1));
				}

				if (tnl.tn.right != null) {
					q.offer(new TreeNodeLevel(tnl.tn.right, tnl.level + 1));
				}
			}

			for (Map.Entry<Integer, List<Integer>> entry : mapLocal.entrySet()) {
				int key = entry.getKey();

				List<Integer> lst = entry.getValue();
				Collections.sort(lst);
				if (map.containsKey(key)) {
					map.get(key).addAll(lst);
				} else {
					map.put(key, lst);
				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}
}
