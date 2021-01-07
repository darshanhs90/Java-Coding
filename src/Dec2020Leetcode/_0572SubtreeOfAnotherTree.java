package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0572SubtreeOfAnotherTree {
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
		TreeNode tn1 = new TreeNode(3);
		tn1.left = new TreeNode(4);
		tn1.right = new TreeNode(5);
		tn1.left.left = new TreeNode(1);
		tn1.left.right = new TreeNode(2);
		TreeNode tn2 = new TreeNode(4);
		tn2.left = new TreeNode(1);
		tn2.right = new TreeNode(2);
		System.out.println(isSubtree(tn1, tn2));
	}

	public static boolean isSubtree(TreeNode s, TreeNode t) {
		HashMap<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
		preOrder(s, map);

		if (map.containsKey(t.val)) {
			for (TreeNode tn : map.get(t.val)) {
				if (checkSubTree(tn, t))
					return true;
			}
		}
		return false;
	}

	public static boolean checkSubTree(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		else if (s == null || t == null)
			return false;
		return s.val == t.val && checkSubTree(s.left, t.left) && checkSubTree(s.right, t.right);
	}

	public static void preOrder(TreeNode s, HashMap<Integer, List<TreeNode>> map) {
		if (s != null) {
			preOrder(s.left, map);
			if (map.containsKey(s.val)) {
				map.get(s.val).add(s);
			} else {
				List<TreeNode> list = new ArrayList<TreeNode>();
				list.add(s);
				map.put(s.val, list);
			}

			preOrder(s.right, map);
		}
	}
}
