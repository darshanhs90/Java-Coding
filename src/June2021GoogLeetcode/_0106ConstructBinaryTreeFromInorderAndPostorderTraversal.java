package June2021GoogLeetcode;

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
		return helper(inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
	}

	public static TreeNode helper(int inStart, int inEnd, int postStart, int[] inorder, int[] postorder) {
		if (inEnd > inStart || postStart < 0)
			return null;

		int inIndex = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (postorder[postStart] == inorder[i]) {
				inIndex = i;
				break;
			}
		}
		TreeNode tn = new TreeNode(postorder[postStart]);
		tn.right = helper(inStart, inIndex + 1, postStart - 1, inorder, postorder);
		tn.left = helper(inIndex - 1, inEnd, postStart - 1 + inIndex - inStart, inorder, postorder);
		return tn;
	}

}