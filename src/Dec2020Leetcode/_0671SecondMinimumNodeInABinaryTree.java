package Dec2020Leetcode;

import java.util.Iterator;
import java.util.TreeSet;

public class _0671SecondMinimumNodeInABinaryTree {
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
		TreeNode tn = new TreeNode(2);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(5);
		tn.right.left = new TreeNode(5);
		tn.right.right = new TreeNode(7);
		System.out.println(findSecondMinimumValue(tn));

		tn = new TreeNode(2);
		tn.left = new TreeNode(2);
		System.out.println(findSecondMinimumValue(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		tn.right.right = new TreeNode(3);
		System.out.println(findSecondMinimumValue(tn));
	}

	public static int findSecondMinimumValue(TreeNode root) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		inorder(root, set);
		System.out.println(set);
		if (set.size() < 2)
			return -1;
		Iterator<Integer> iter = set.iterator();
		return Math.max(iter.next(), iter.next());
	}

	public static void inorder(TreeNode root, TreeSet<Integer> set) {
		if (root == null)
			return;
		inorder(root.left, set);
		if (!set.contains(root.val))
			set.add(root.val);
		inorder(root.right, set);
	}

}
