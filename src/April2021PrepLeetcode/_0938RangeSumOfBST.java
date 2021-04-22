package April2021PrepLeetcode;

public class _0938RangeSumOfBST {

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
		TreeNode tn = new TreeNode(10);
		tn.left = new TreeNode(5);
		tn.right = new TreeNode(15);
		tn.left.left = new TreeNode(3);
		tn.left.right = new TreeNode(7);
		tn.right.right = new TreeNode(18);
		System.out.println(rangeSumBST(tn, 7, 15));

		tn = new TreeNode(10);
		tn.left = new TreeNode(5);
		tn.right = new TreeNode(15);

		tn.left.left = new TreeNode(3);
		tn.left.right = new TreeNode(7);
		tn.left.left.left = new TreeNode(1);
		tn.left.right.left = new TreeNode(6);

		tn.right.left = new TreeNode(13);
		tn.right.right = new TreeNode(18);
		System.out.println(rangeSumBST(tn, 6, 10));

	}

	public static int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null)
			return 0;
		if (root.val >= low && root.val <= high) {
			return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
		}

		if (root.val > high) {
			return rangeSumBST(root.left, low, high);
		} else if (root.val < low) {
			return rangeSumBST(root.right, low, high);
		}
		return 0;
	}
}
