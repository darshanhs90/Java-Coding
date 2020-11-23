package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0236LowestCommonAncestorOfABinaryTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(5);
		tn.left.left = new TreeNode(6);
		tn.left.right = new TreeNode(2);
		tn.left.right.left = new TreeNode(7);
		tn.left.right.right = new TreeNode(4);

		tn.right = new TreeNode(1);
		tn.right.left = new TreeNode(0);
		tn.right.right = new TreeNode(8);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.right).val);
		System.out.println(lowestCommonAncestor(tn, tn.left, tn.left.right.right).val);
		System.out.println(lowestCommonAncestor(tn, tn, tn.left).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		List<TreeNode> pList = new ArrayList<TreeNode>();
		List<TreeNode> qList = new ArrayList<TreeNode>();
		findNode(root, p, pList);
		findNode(root, q, qList);

		int minLen = Math.min(pList.size(), qList.size());
		for (int i = 0; i < minLen; i++) {
			if (pList.get(i) != qList.get(i)) {
				return pList.get(i - 1);
			}
		}

		return pList.get(minLen - 1);
	}

	public static boolean findNode(TreeNode root, TreeNode p, List<TreeNode> list) {
		if (root == null)
			return false;

		list.add(root);
		if (root == p) {
			return true;
		}
		if (findNode(root.left, p, list)) {
			return true;
		}
		if (findNode(root.right, p, list)) {
			return true;
		}
		list.remove(list.size() - 1);
		return false;
	}

}
