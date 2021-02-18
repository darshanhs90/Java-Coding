package Jan2021Leetcode;

public class _0285InorderSuccessorInBST {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(2);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(3);
		System.out.println(inorderSuccessor(tn, tn.left));

		tn = new TreeNode(5);
		tn.left = new TreeNode(3);
		tn.right = new TreeNode(6);
		tn.left.left = new TreeNode(2);
		tn.left.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(4);

		System.out.println(inorderSuccessor(tn, tn.left.left.left));
	}

	static boolean nodeFound;
	static TreeNode out;

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		nodeFound = false;
		out = null;
		inOrder(root, p);
		return out;
	}

	public static void inOrder(TreeNode root, TreeNode p) {
		if (root == null)
			return;
		inOrder(root.left, p);
		if (nodeFound) {
			out = root;
			nodeFound = false;
			return;
		} else if (root == p) {
			nodeFound = true;
		}
		inOrder(root.right, p);
	}

}
