package April2021PrepLeetcode;

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

	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.left);
		flatten(root.right);
		TreeNode left = root.left;
		if (left != null) {
			TreeNode leftPtr = left;
			while (left != null && left.right != null) {
				left = left.right;
			}
			left.right = root.right;
			root.right = leftPtr;
			root.left = null;
		}
	}

	public static void printNodes(TreeNode root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.right;
		}
	}

}
