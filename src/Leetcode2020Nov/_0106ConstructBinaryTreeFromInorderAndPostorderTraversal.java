package Leetcode2020Nov;

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
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(2);
		tn.left.left = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		tn.right.left = new TreeNode(4);
		tn.right.right = new TreeNode(3);
		System.out.println(maxDepth(tn));
		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(2);
		tn.left.right = new TreeNode(3);
		tn.right.right = new TreeNode(3);
		System.out.println(maxDepth(tn));
	}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
    }
}