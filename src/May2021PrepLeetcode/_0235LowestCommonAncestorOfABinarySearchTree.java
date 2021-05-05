package May2021PrepLeetcode;

public class _0235LowestCommonAncestorOfABinarySearchTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(6);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(0);
		tn.left.right = new TreeNode(4);
		tn.left.right.left = new TreeNode(3);
		tn.left.right.right = new TreeNode(5);

		tn.right = new TreeNode(8);
		tn.right.left = new TreeNode(7);
		tn.right.right = new TreeNode(9);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.right).val);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.left.right).val);
		System.out.println(lowestCommonAncestor(tn, tn, tn.left).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p == q)
			return p;
		if (root == p || root == q)
			return root;

		if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val))
			return root;

		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}

}
