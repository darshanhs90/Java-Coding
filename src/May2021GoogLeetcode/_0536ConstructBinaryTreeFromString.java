package May2021GoogLeetcode;

public class _0536ConstructBinaryTreeFromString {

	public static void main(String[] args) {
		System.out.println(str2tree("4(2(3)(1))(6(5))"));
		System.out.println(str2tree("4(2(3)(1))(6(5)(7))"));
		System.out.println(str2tree("-4(2(3)(1))(6(5)(7))"));
	}

	public static class TreeNode {
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

	public static TreeNode str2tree(String s) {

	}

}
