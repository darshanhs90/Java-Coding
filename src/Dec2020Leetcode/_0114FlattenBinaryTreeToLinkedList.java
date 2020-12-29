package Dec2020Leetcode;

public class _0114FlattenBinaryTreeToLinkedList {
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
		tn.right = new TreeNode(5);
		tn.left.left = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		tn.right.right = new TreeNode(6);
		flatten(tn);
		System.out.println();
		tn = new TreeNode(1);
		tn.right = new TreeNode(2);
		tn.right.left = new TreeNode(3);
		flatten(tn);
	}

	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		flattenHelper(root);
		printNodes(root);
	}

	public static void printNodes(TreeNode root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.right;
		}
	}

	public static TreeNode flattenHelper(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;

		TreeNode leftNode = flattenHelper(root.left);
		TreeNode leftNodePtr = leftNode;

		TreeNode rightNode = flattenHelper(root.right);

		while (leftNode != null && leftNode.right != null) {
			leftNode = leftNode.right;
		}
		if (leftNode != null) {
			leftNode.right = rightNode;
			root.left = null;
			root.right = leftNodePtr;
		}
		return root;
	}

}
