package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _0366FindLeavesOfBinaryTree {
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
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		System.out.println(findLeaves(tn));
	}

	public static List<List<Integer>> findLeaves(TreeNode root) {
		HashMap<TreeNode, HashSet<TreeNode>> map = new HashMap<TreeNode, HashSet<TreeNode>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (root == null)
			return output;
		q.offer(root);
		Queue<TreeNode> leafNodes = new LinkedList<TreeNode>();

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode tn = q.poll();
				map.put(tn, new HashSet<TreeNode>());
				if (tn.left != null) {
					map.get(tn).add(tn.left);
					q.offer(tn.left);
				}
				if (tn.right != null) {
					map.get(tn).add(tn.right);
					q.offer(tn.right);
				}

				if (tn.left == null && tn.right == null) {
					leafNodes.offer(tn);
				}
			}
		}

		while (!leafNodes.isEmpty()) {
			int size = leafNodes.size();
			List<Integer> innerList = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode tn = leafNodes.poll();
				innerList.add(tn.val);
				map.remove(tn);
				for (Map.Entry<TreeNode, HashSet<TreeNode>> entry : map.entrySet()) {
					if (entry.getValue().contains(tn))
						entry.getValue().remove(tn);
				}
			}

			for (Map.Entry<TreeNode, HashSet<TreeNode>> entry : map.entrySet()) {
				if (entry.getValue().size() == 0) {
					leafNodes.offer(entry.getKey());
				}
			}
			output.add(innerList);
		}
		return output;
	}

}
