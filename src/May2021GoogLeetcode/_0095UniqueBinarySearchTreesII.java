package May2021GoogLeetcode;

import java.util.List;

public class _0095UniqueBinarySearchTreesII {
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
		System.out.println(generateTrees(3));
	}

	public static List<TreeNode> generateTrees(int n) {

	}

}
