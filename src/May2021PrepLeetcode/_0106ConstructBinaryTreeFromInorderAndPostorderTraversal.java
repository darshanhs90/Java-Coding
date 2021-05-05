package May2021PrepLeetcode;

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
		return helper(postorder.length - 1, inorder.length - 1, 0, inorder, postorder);
	}

	public static TreeNode helper(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
		if (postStart < 0 || inStart < inEnd)
			return null;

		int inIndex = -1;
		for (int i = inEnd; i <= inStart; i++) {
			if (inorder[i] == postorder[postStart]) {
				inIndex = i;
				break;
			}
		}

		TreeNode tn = new TreeNode(postorder[postStart]);
		tn.right = helper(postStart - 1, inStart, inIndex + 1, inorder, postorder);
		tn.left = helper(postStart - 1 + inIndex - inStart, inIndex - 1, inEnd, inorder, postorder);
		return tn;
	}
}