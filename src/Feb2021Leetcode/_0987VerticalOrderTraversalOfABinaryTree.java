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

	static class Pair {
		TreeNode tn;
		int level;

		public Pair(TreeNode tn, int level) {
			this.tn = tn;
			this.level = level;
		}
	}

	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		if (root == null)
			return new ArrayList<List<Integer>>();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			TreeMap<Integer, List<Integer>> tempMap = new TreeMap<Integer, List<Integer>>();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();

				if (!tempMap.containsKey(pair.level)) {
					tempMap.put(pair.level, new ArrayList<Integer>());
				}
				tempMap.get(pair.level).add(pair.tn.val);

				if (pair.tn.left != null) {
					q.offer(new Pair(pair.tn.left, pair.level - 1));
				}

				if (pair.tn.right != null) {
					q.offer(new Pair(pair.tn.right, pair.level + 1));
				}
			}
			mergeMap(map, tempMap);
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}

		return output;
	}

	public static void mergeMap(TreeMap<Integer, List<Integer>> mainMap, TreeMap<Integer, List<Integer>> copyMap) {
		for (Map.Entry<Integer, List<Integer>> entry : copyMap.entrySet()) {
			Integer key = entry.getKey();
			List<Integer> value = entry.getValue();
			Collections.sort(value);
			if (!mainMap.containsKey(key)) {
				mainMap.put(key, new ArrayList<Integer>());
			}

			mainMap.get(key).addAll(value);
		}

	}
}
