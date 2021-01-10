package Dec2020Leetcode;

public class _1022SumOfRootToLeafBinaryNumbers {
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
		tn.left = new TreeNode(0);
		tn.left.left = new TreeNode(0);
		tn.left.right = new TreeNode(1);
		tn.right = new TreeNode(1);
		tn.right.left = new TreeNode(0);
		tn.right.right = new TreeNode(1);

		System.out.println(sumRootToLeaf(tn));

		tn = new TreeNode(0);
		System.out.println(sumRootToLeaf(tn));

		tn = new TreeNode(1);
		System.out.println(sumRootToLeaf(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(1);
		System.out.println(sumRootToLeaf(tn));
	}

	static int sum;

	public static int sumRootToLeaf(TreeNode root) {
		if (root == null)
			return 0;
		sum = 0;
		preOrder(root, "");
		return sum;
	}

	public static void preOrder(TreeNode root, String curr) {
		if (root == null)
			return;
		curr += root.val;
		if (root.left == null && root.right == null) {
			sum += Integer.parseInt(curr, 2);
		}
		preOrder(root.left, curr);
		preOrder(root.right, curr);
	}

}
