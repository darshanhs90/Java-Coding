package Dec2020Leetcode;

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
		System.out.println(distanceK(tn, tn.left, 3));
	}

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
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
		List<Integer> output = new ArrayList<Integer>();
		addChildNodes(target, K, visited, output);
		K--;
		while (K >= 0) {
			TreeNode parent = parentMap.get(target);
			if (parent == null)
				return output;
			addChildNodes(parent, K, visited, output);
			visited.add(parent);
			target = parent;
			K--;
		}
		return output;
	}

	public static void addChildNodes(TreeNode root, int k, HashSet<TreeNode> visited, List<Integer> output) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty() && k >= 0) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (!visited.contains(tn)) {
					visited.add(tn);
					if (k == 0) {
						output.add(tn.val);
					}

					if (tn.left != null)
						q.offer(tn.left);
					if (tn.right != null)
						q.offer(tn.right);
				}
			}
			k--;
		}
	}

}
