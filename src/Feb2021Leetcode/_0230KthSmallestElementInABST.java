package Feb2021Leetcode;

public class _0230KthSmallestElementInABST {
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
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(4);
		tn.left.right = new TreeNode(2);
		System.out.println(kthSmallest(tn, 1));

		tn = new TreeNode(5);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(6);
		tn.left.left = new TreeNode(2);
		tn.left.right = new TreeNode(4);
		tn.left.left.left = new TreeNode(1);
		System.out.println(kthSmallest(tn, 3));

		tn = new TreeNode(2);
		tn.left = new TreeNode(1);
		System.out.println(kthSmallest(tn, 1));
	}

	public static int kthSmallest(TreeNode root, int k) {

	}

}
