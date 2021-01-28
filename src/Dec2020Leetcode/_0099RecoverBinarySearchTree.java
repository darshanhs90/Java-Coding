package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0099RecoverBinarySearchTree {
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
		tn.left = new TreeNode(3);
		tn.left.right = new TreeNode(2);
		preOrder(tn);
		System.out.println();
		recoverTree(tn);
		preOrder(tn);
		System.out.println();
	}

	public static void preOrder(TreeNode root) {
		if (root != null) {
			preOrder(root.left);
			System.out.print(root.val + "/");
			preOrder(root.right);
		}
	}

	public static void recoverTree(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inOrder(root, list);
		int[] nums = swapNonIncreasingNumbers(list);
		inOrderChange(root, nums[0], nums[1], 2);
	}

	public static int[] swapNonIncreasingNumbers(List<Integer> list) {
		int x = -1, y = -1;
		for (int i = 0; i < list.size() - 1; ++i) {
			if (list.get(i + 1) < list.get(i)) {
				y = list.get(i + 1);
				if (x == -1)
					x = list.get(i);
				else
					break;
			}
		}
		return new int[] { x, y };
	}

	public static void inOrder(TreeNode root, List<Integer> list) {
		if (root != null) {
			inOrder(root.left, list);
			list.add(root.val);
			inOrder(root.right, list);
		}
	}

	public static void inOrderChange(TreeNode root, int x, int y, int count) {
		if (root != null || count <= 0) {
			if (root.val == x || root.val == y) {
				if (root.val == x) {
					root.val = y;
				} else {
					root.val = x;
				}
				count--;
				if (count == 0)
					return;
			}
			inOrderChange(root.left, x, y, count);
			inOrderChange(root.right, x, y, count);
		}
	}
}
