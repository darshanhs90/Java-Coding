package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
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

		tn = new TreeNode(3);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(4);
		tn.right.left = new TreeNode(2);
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

	static int index;

	public static void recoverTree(TreeNode root) {
		if (root == null)
			return;
		index = 0;
		List<Integer> list = new ArrayList<Integer>();
		inOrder(root, list);
		Collections.sort(list);
		inOrderChange(root, list);
	}

	public static void inOrderChange(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inOrderChange(root.left, list);
		if (root.val != list.get(index)) {
			root.val = list.get(index);
		}
		index++;
		inOrderChange(root.right, list);
	}

	public static void inOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}

}
