package April2021PrepLeetcode;

import java.util.List;

public class _0545BoundaryOfBinaryTree {

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
		tn.right = new TreeNode(2);
		tn.right.left = new TreeNode(3);
		tn.right.right = new TreeNode(4);
		System.out.println(boundaryOfBinaryTree(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.left.right.left = new TreeNode(7);
		tn.left.right.right = new TreeNode(8);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(6);
		tn.right.left.left = new TreeNode(9);
		tn.right.left.right = new TreeNode(10);
		System.out.println(boundaryOfBinaryTree(tn));
	}

	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
	}

}
