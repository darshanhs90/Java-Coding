package Nov2020_FBPrep;

public class _028FlattenBinaryTreeToLinkedList {
	static public class TreeNode {
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
		printRightNodes(tn);
	}

	public static void printRightNodes(TreeNode root) {
		while (root != null) {
			System.out.print(root.val + "->");
			root = root.right;
		}
		System.out.println();
	}

	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		if (root.right != null)
			flatten(root.right);
		if (root.left != null)
			flatten(root.left);

		TreeNode left = root.left;
		TreeNode leftPtr = left;

		if (left != null) {
			while (left != null && left.right != null) {
				left = left.right;
			}
			left.right = root.right;
			root.right = leftPtr;
		}
		root.left = null;
	}
}
