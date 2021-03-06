package Feb2021Leetcode;

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
		printNodes(tn);

		System.out.println();
		tn = new TreeNode(1);
		tn.right = new TreeNode(2);
		tn.right.left = new TreeNode(3);
		flatten(tn);
		printNodes(tn);
	}

	public static void printNodes(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + "->");
		printNodes(root.right);
	}

	public static void flatten(TreeNode root) {
		s
	}

}
