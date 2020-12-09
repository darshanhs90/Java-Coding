package Nov2020_FBPrep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class _033LowestCommonAncestorOfABinaryTree {

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
		if (root == null || root == p || root == q)
			return root;
		if (p == q)
			return p;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashMap<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		parentMap.put(root, null);
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode tn = stack.pop();
			TreeNode left = tn.left;
			TreeNode right = tn.right;
			if (left != null) {
				stack.push(left);
				parentMap.put(left, tn);
			}
			if (right != null) {
				stack.push(right);
				parentMap.put(right, tn);
			}
		}

		HashSet<TreeNode> ancestors = new HashSet<TreeNode>();
		TreeNode tn = p;
		while (tn != null) {
			ancestors.add(tn);
			tn = parentMap.get(tn);
		}

		tn = q;
		while (tn != null) {
			if (ancestors.contains(tn))
				return tn;
			tn = parentMap.get(tn);
		}
		return null;
	}
}
