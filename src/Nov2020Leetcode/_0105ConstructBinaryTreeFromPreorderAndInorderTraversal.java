package Nov2020Leetcode;

public class _0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
		printNodes(buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }));
		System.out.println();
	}

	public static void printNodes(TreeNode tn) {
		if (tn == null)
			return;
		System.out.print(tn.val + "->");
		printNodes(tn.left);
		printNodes(tn.right);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preStart]);

		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (root.val == inorder[i])
				inIndex = i;
		}

		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

		return root;
	}
}