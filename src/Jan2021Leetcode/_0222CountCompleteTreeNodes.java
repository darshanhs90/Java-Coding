package Jan2021Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0222CountCompleteTreeNodes {
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
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(6);
		System.out.println(countNodes(tn));
	}

	public static int countNodes(TreeNode root) {
	
	}

}
