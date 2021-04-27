package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _1382BalanceABinarySearchTree {
	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.right = new TreeNode(2);
		tn.right.right = new TreeNode(3);
		tn.right.right.right = new TreeNode(4);
		printNodes(tn);
		System.out.println();
		tn = balanceBST(tn);
		printNodes(tn);
	}

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

	public static void printNodes(TreeNode root) {
		if (root == null)
			return;
		printNodes(root.left);
		System.out.print(root.val + "/");
		printNodes(root.right);
	}

	public static TreeNode balanceBST(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inOrder(root, list);
		return buildTree(list);
	}

	public static TreeNode buildTree(List<Integer> list) {
		return buildTree(0, list.size() - 1, list);
	}

	public static TreeNode buildTree(int left, int right, List<Integer> list) {
		if (left > right || left < 0 || right >= list.size())
			return null;
		int mid = (left + right) / 2;

		TreeNode tn = new TreeNode(list.get(mid));
		tn.left = buildTree(left, mid - 1, list);
		tn.right = buildTree(mid + 1, right, list);
		return tn;
	}

	public static void inOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}

}
