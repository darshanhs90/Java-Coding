package Dec2020Leetcode;

public class _0965UnivaluedBinaryTree {
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
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(1);
		System.out.println(isUnivalTree(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(1);
		tn.left.left = new TreeNode(2);
		System.out.println(isUnivalTree(tn));

		tn = new TreeNode(9);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(6);
		tn.left.left = new TreeNode(9);
		tn.left.right = new TreeNode(9);
		System.out.println(isUnivalTree(tn));
	}

	
}
