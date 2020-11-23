package Nov2020Leetcode;

public class _0606ConstructStringFromBinaryTree {

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
		tn.left.left = new TreeNode(4);
		System.out.println(tree2str(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.left.right = new TreeNode(4);
		System.out.println(tree2str(tn));
	}

	public static String tree2str(TreeNode t) {
		if (t == null)
			return "";
		String str = t.val + "";

		String leftString = tree2str(t.left);
		String rightString = tree2str(t.right);
		if (leftString == "" && rightString == "") {
			return str;
		}
		if (leftString == "" && rightString != "") {
			return str + "()" + "(" + rightString + ")";
		}
		if (leftString != "" && rightString == "") {
			return str + "(" + leftString + ")";
		}

		return str + "(" + leftString + ")" + "(" + rightString + ")";
	}
}
