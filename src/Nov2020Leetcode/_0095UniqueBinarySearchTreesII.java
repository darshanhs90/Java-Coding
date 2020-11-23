package Nov2020Leetcode;

import java.util.ArrayList;
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
		if (n <= 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	public static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> output = new ArrayList<TreeNode>();
		if (start > end) {
			output.add(null);
			return output;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
			List<TreeNode> rightSubTrees = generateTrees(i + 1, end);

			for (TreeNode treeNodeLeft : leftSubTrees) {
				for (TreeNode treeNodeRight : rightSubTrees) {
					TreeNode tn = new TreeNode(i);
					tn.left = treeNodeLeft;
					tn.right = treeNodeRight;
					output.add(tn);
				}
			}
		}

		return output;
	}
}
