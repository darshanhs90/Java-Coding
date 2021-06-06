package June2021GoogLeetcode;

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

	static TreeNode next;
	static boolean nodeFound;

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		nodeFound = false;
		next = null;
		inorder(root, p);
		return next;
	}

	public static void inorder(TreeNode root, TreeNode p) {
		if (next != null || root == null)
			return;
		inorder(root.left, p);
		if (nodeFound && next == null) {
			next = root;
			return;
		}
		if (root == p) {
			nodeFound = true;
		}

		inorder(root.right, p);
	}

}
