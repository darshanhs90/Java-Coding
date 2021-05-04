package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class _1305AllElementsInTwoBinarySearchTrees {
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
		TreeNode tn1 = new TreeNode(2);
		tn1.left = new TreeNode(1);
		tn1.right = new TreeNode(4);

		TreeNode tn2 = new TreeNode(1);
		tn2.left = new TreeNode(0);
		tn2.right = new TreeNode(3);

		System.out.println(getAllElements(tn1, tn2));

	}

	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		
	}

}
