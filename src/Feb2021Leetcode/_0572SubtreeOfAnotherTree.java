package Feb2021Leetcode;

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

	static boolean matches;

	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		else if (s == null || t == null)
			return false;

		matches = false;
		preOrder(s, t);

		return matches;

	}

	public static void preOrder(TreeNode s, TreeNode t) {
		if (s == null || matches) {
			return;
		}

		if (s.val == t.val) {
			if (matchesTree(s, t)) {
				matches = true;
				return;
			}
		}
		preOrder(s.left, t);
		preOrder(s.right, t);
	}

	public static boolean matchesTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null)
			return false;
		return s.val == t.val && matchesTree(s.left, t.left) && matchesTree(s.right, t.right);
	}
}
