package Dec2020Leetcode;

import java.util.Arrays;

public class _0106ConstructBinaryTreeFromInorderAndPostorderTraversal {
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
		printNodes(buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }));
		System.out.println();
	}

	public static void printNodes(TreeNode tn) {
		if (tn == null)
			return;
		printNodes(tn.left);
		System.out.print(tn.val + "->");
		printNodes(tn.right);
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0)
			return null;
		TreeNode tn = new TreeNode(postorder[postorder.length - 1]);
		if (postorder.length == 1)
			return tn;
		int val = postorder[postorder.length - 1];
		int index = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == val) {
				index = i;
				break;
			}
		}

		tn.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
		tn.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length),
				Arrays.copyOfRange(postorder, index, postorder.length - 1));
		return tn;
	}
}