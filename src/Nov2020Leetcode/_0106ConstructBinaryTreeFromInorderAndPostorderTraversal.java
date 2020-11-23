package Nov2020Leetcode;

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
		System.out.print(tn.val + "->");
		printNodes(tn.left);
		printNodes(tn.right);
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
	}

	public static TreeNode helper(int posStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
		if (posStart < 0 || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(postorder[posStart]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (root.val == inorder[i])
				inIndex = i;
		}

		root.right = helper(posStart - 1, inIndex + 1, inEnd, inorder, postorder);
		root.left = helper(posStart - 1 - inEnd + inIndex, inStart, inIndex - 1, inorder, postorder);
		return root;
	}
}