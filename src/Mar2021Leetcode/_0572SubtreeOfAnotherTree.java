package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0572SubtreeOfAnotherTree {
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
		TreeNode tn1 = new TreeNode(3);
		tn1.left = new TreeNode(4);
		tn1.right = new TreeNode(5);
		tn1.left.left = new TreeNode(1);
		tn1.left.right = new TreeNode(2);
		TreeNode tn2 = new TreeNode(4);
		tn2.left = new TreeNode(1);
		tn2.right = new TreeNode(2);
		System.out.println(isSubtree(tn1, tn2));
	}

	public static boolean isSubtree(TreeNode s, TreeNode t) {
		
	}
}
