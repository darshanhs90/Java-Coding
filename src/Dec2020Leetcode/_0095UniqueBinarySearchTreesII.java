package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
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
		if (n == 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	public static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new LinkedList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {

			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode tn = new TreeNode(i);
					tn.left = l;
					tn.right = r;
					list.add(tn);
				}
			}
		}
		return list;
	}

}
