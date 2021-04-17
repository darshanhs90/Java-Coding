package April2021PrepLeetcode;

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

	}

}
