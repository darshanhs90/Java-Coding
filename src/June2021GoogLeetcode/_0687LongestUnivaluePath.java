package June2021GoogLeetcode;

public class _0687LongestUnivaluePath {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(5);
		tn.left = new TreeNode(4);
		tn.left.left = new TreeNode(1);
		tn.left.right = new TreeNode(1);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(longestUnivaluePath(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(4);
		tn.left.left = new TreeNode(4);
		tn.left.right = new TreeNode(4);
		tn.right = new TreeNode(5);
		tn.right.right = new TreeNode(5);
		System.out.println(longestUnivaluePath(tn));
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

	public static int longestUnivaluePath(TreeNode root) {
	
	}

}
