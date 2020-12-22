package LeetcodeTemplate;

import java.util.List;

public class _0220ContainsDuplicateIII {
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
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));
		System.out.println(rob(new int[] { 1, 2 }));
		System.out.println(rob(new int[] { 1 }));
	}

	public List<Integer> rightSideView(TreeNode root) {

	}
}
