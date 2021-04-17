package LeetcodeTemplate;

import java.util.List;

public class _0199BinaryTreeRightSideView {
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
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(3);
		tn.right.right = new TreeNode(4);
		System.out.println(rightSideView(tn));

	}

	public static List<Integer> rightSideView(TreeNode root) {

	}
}
