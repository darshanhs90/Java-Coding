package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0113PathSumII {
	public static class TreeNode {
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
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(4);
		tn.right = new TreeNode(8);
		tn.left.left = new TreeNode(11);
		tn.left.left.left = new TreeNode(7);
		tn.left.left.right = new TreeNode(2);
		tn.right.left = new TreeNode(13);
		tn.right.right = new TreeNode(4);
		tn.right.right.left = new TreeNode(5);
		tn.right.right.right = new TreeNode(1);
		System.out.println(pathSum(tn, 22));
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		pathSum(root, sum, new ArrayList<Integer>(), output);
		return output;
	}

	public static void pathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> output) {
		if (root == null)
			return;
		if (root.left == null && root.right == null && sum - root.val == 0) {
			list.add(root.val);
			output.add(new ArrayList<Integer>(list));
			list.remove(list.size() - 1);
			return;
		}
		list.add(root.val);
		pathSum(root.left, sum - root.val, list, output);
		pathSum(root.right, sum - root.val, list, output);
		list.remove(list.size() - 1);
	}

}
