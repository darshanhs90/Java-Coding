package April2021Leetcode;

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
		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		parentMap.put(root, null);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				if (tn.left != null) {
					q.offer(tn.left);
					parentMap.put(tn.left, tn);
				}

				if (tn.right != null) {
					q.offer(tn.right);
					parentMap.put(tn.right, tn);
				}
			}
		}
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		while (target != null && K >= 0) {
			addChildNode(target, K, visited, list);
			target = parentMap.get(target);
			K--;
		}
		return list;
	}

	public static void addChildNode(TreeNode node, int K, HashSet<TreeNode> visited, List<Integer> list) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(node);
		visited.add(node);
		while (!q.isEmpty() && K > 0) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				visited.add(tn);
				if (tn.left != null && !visited.contains(tn.left)) {
					q.offer(tn.left);
				}

				if (tn.right != null && !visited.contains(tn.right)) {
					q.offer(tn.right);
				}
			}
			K--;
		}

		while (!q.isEmpty()) {
			list.add(q.poll().val);
		}
	}

}
