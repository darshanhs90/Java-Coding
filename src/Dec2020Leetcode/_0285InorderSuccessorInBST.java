package Dec2020Leetcode;

import java.util.HashMap;

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

	static TreeNode prev = null;

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		HashMap<TreeNode, TreeNode> successor = new HashMap<TreeNode, TreeNode>();
		prev = null;
		inorder(root, p, successor);
		return successor.containsKey(p) ? successor.get(p) : null;
	}

	public static void inorder(TreeNode root, TreeNode p, HashMap<TreeNode, TreeNode> successor) {
		if (root == null)
			return;

		inorder(root.left, p, successor);
		successor.put(prev, root);
		prev = root;
		inorder(root.right, p, successor);
	}

}
