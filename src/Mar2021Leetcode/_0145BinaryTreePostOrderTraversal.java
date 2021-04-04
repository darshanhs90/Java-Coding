package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0145BinaryTreePostOrderTraversal {
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
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		System.out.println(postorderTraversal(tn));

		tn = new TreeNode(4);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(0);
		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(1);
		System.out.println(postorderTraversal(tn));
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postorder(root, list);
		return list;
	}

	public static void postorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		postorder(root.left, list);
		postorder(root.right, list);
		list.add(root.val);
	}

}
