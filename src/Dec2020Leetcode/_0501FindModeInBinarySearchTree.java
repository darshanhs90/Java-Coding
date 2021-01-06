package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0501FindModeInBinarySearchTree {
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
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(2);
		tn.right.left = new TreeNode(2);
		System.out.println(Arrays.toString(findMode(tn)));
	}

	static int max;

	public static int[] findMode(TreeNode root) {
		if (root == null)
			return new int[] {};
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		max = 0;
		preOrder(root, map);
		List<Integer> list = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				list.add(entry.getKey());
			}
		}
		int[] out = new int[list.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = list.get(i);
		}

		return out;
	}

	public static void preOrder(TreeNode root, HashMap<Integer, Integer> map) {
		if (root == null)
			return;
		map.compute(root.val, (k, v) -> v == null ? 1 : v + 1);
		max = Math.max(max, map.get(root.val));
		preOrder(root.left, map);
		preOrder(root.right, map);
	}

}
