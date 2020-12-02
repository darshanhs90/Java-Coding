package Nov2020_GoogPrep;

public class _045FlipEquivalentBinaryTrees {
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
		TreeNode tn1 = new TreeNode(1);
		tn1.left = new TreeNode(2);
		tn1.right = new TreeNode(3);
		tn1.left.left = new TreeNode(4);
		tn1.left.right = new TreeNode(5);
		tn1.left.right.left = new TreeNode(7);
		tn1.left.right.right = new TreeNode(8);
		tn1.right.left = new TreeNode(6);

		TreeNode tn2 = new TreeNode(1);
		tn2.left = new TreeNode(3);
		tn2.right = new TreeNode(2);
		tn2.right.left = new TreeNode(4);
		tn2.right.right = new TreeNode(5);
		tn2.right.right.left = new TreeNode(8);
		tn2.right.right.right = new TreeNode(7);
		tn2.left.right = new TreeNode(7);

		System.out.println(flipEquiv(tn1, tn2));
	}

	public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		else if ((root1 == null && root2 != null) || (root2 == null && root1 != null))
			return false;
		return root1.val == root2.val && ((flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
				|| (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)));
	}
}
