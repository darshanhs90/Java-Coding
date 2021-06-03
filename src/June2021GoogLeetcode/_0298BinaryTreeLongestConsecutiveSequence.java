package June2021GoogLeetcode;

public class _0298BinaryTreeLongestConsecutiveSequence {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		tn.right.right = new TreeNode(4);
		tn.right.right.right = new TreeNode(5);
		System.out.println(longestConsecutive(tn));

		tn = new TreeNode(2);
		tn.right = new TreeNode(3);
		tn.right.left = new TreeNode(2);
		tn.right.left.left = new TreeNode(1);
		System.out.println(longestConsecutive(tn));

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

	public static int longestConsecutive(TreeNode root) {
		
	}

}
