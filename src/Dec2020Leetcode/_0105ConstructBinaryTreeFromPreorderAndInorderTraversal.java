package Dec2020Leetcode;

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
		printNodes(tn.left);
		System.out.print(tn.val + "->");
		printNodes(tn.right);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0)
			return null;

		return buildTree(0, 0, inorder.length - 1, preorder, inorder);
	}

	public static TreeNode buildTree(int preOrderIndex, int inorderStart, int inorderEnd, int[] preorder,
			int[] inorder) {
		if (inorderStart > inorderEnd)
			return null;
        if (inorderStart == inorderEnd)
            return new TreeNode(inorder[inorderStart]);
        
		int val = preorder[preOrderIndex];
		TreeNode tn = new TreeNode(val);

		int inorderIndex = findIndex(val, inorder);
        int leftCount = inorderIndex - inorderStart;
		TreeNode left = buildTree(preOrderIndex + 1, inorderStart, inorderIndex - 1, preorder, inorder);
		TreeNode right = buildTree(preOrderIndex + leftCount + 1, inorderIndex + 1, inorderEnd, preorder, inorder);
		tn.left = left;
		tn.right = right;
		return tn;
	}

	public static int findIndex(int val, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			if (val == inorder[i])
				return i;
		}
		return -1;
	}

}