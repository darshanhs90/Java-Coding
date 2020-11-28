package Nov2020_GfG;

public class _009PrintLeafNodesFromPreorderYraversalOfBST {

	static class TreeNode {
		TreeNode left, right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.left = new TreeNode(4);
		tn.right.left = new TreeNode(5);
		tn.right.right = new TreeNode(6);
		preOrderLeftNodes(tn);
	}

	static void preOrderLeftNodes(TreeNode tn) {
		if (tn == null)
			return;
		if (tn.left == null && tn.right == null) {
			System.out.println(tn.val);
			return;
		}
		preOrderLeftNodes(tn.left);
		preOrderLeftNodes(tn.right);
	}
}
