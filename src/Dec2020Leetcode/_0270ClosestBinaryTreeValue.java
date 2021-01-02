package Dec2020Leetcode;

public class _0270ClosestBinaryTreeValue {
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
		TreeNode tn = new TreeNode(4);
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(5);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(3);
		System.out.println(closestValue(tn, 3.714286));
	}

	static double diff = Double.MAX_VALUE;
	static int nodeVal;

	public static int closestValue(TreeNode root, double target) {
		diff = Double.MAX_VALUE;
		findDiff(root, target);
		return nodeVal;
	}

	public static void findDiff(TreeNode root, double target) {
		if (root == null)
			return;
		double currDiff = Math.abs(target - root.val);
		if (currDiff < diff) {
			diff = currDiff;
			nodeVal = root.val;
		}
		if (target > root.val) {
			findDiff(root.right, target);
		} else {
			findDiff(root.left, target);
		}
	}

}
