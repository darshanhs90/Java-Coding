package Oct2023Leetcode;

public class _0108ConvertSortedArrayToBinarySearchTree {
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
		printNodes(sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));
	}

	public static void printNodes(TreeNode tn) {
		if (tn == null)
			return;
		printNodes(tn.left);
		System.out.println(tn.val);
		printNodes(tn.right);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {

	}

}
