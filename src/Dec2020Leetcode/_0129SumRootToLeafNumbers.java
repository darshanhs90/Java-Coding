package Dec2020Leetcode;

public class _0129SumRootToLeafNumbers {
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
		System.out.println(sumNumbers(tn));

		tn = new TreeNode(4);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(0);
		tn.left.left = new TreeNode(5);
		tn.left.right = new TreeNode(1);
		System.out.println(sumNumbers(tn));
	}

	static int sum = 0;

	public static int sumNumbers(TreeNode root) {
		sum = 0;
		preOrder("", root);
		return sum;
	}

	public static void preOrder(String str, TreeNode root) {
		if (root == null) {

			return;
		}

		if (root.left == null && root.right == null) {
			str += root.val;
			sum += Integer.parseInt(str);
			return;
		}

		preOrder(str + root.val, root.left);
		preOrder(str + root.val, root.right);
	}

}
