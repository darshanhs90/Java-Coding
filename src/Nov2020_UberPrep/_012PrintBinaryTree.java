package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _012PrintBinaryTree {

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
		System.out.println(printTree(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.left.right = new TreeNode(4);
		tn.right = new TreeNode(3);
		System.out.println(printTree(tn));

		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		tn.left.left = new TreeNode(3);
		tn.left.left.left = new TreeNode(4);
		tn.right = new TreeNode(5);
		System.out.println(printTree(tn));
	}

	public static List<List<String>> printTree(TreeNode root) {
		int height = getHeight(root);
		List<List<String>> output = new ArrayList<List<String>>();
		String[][] result = new String[height][(int) (Math.pow(2, height) - 1)];
		for (int i = 0; i < result.length; i++) {
			Arrays.fill(result[i], "");
		}

		fill(root, result, 0, 0, result[0].length - 1);
		for (int i = 0; i < result.length; i++) {
			output.add(Arrays.asList(result[i]));
		}
		return output;
	}

	public static void fill(TreeNode root, String[][] result, int level, int left, int right) {
		if (root == null)
			return;
		int mid = (left + right) / 2;
		result[level][mid] = root.val + "";

		fill(root.left, result, level + 1, left, mid - 1);
		fill(root.right, result, level + 1, mid + 1, right);
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

}
