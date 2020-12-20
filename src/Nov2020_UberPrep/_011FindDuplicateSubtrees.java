package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _011FindDuplicateSubtrees {
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
		tn.left.left = new TreeNode(4);

		tn.right = new TreeNode(3);
		tn.right.right = new TreeNode(4);
		tn.right.left = new TreeNode(2);
		tn.right.left.left = new TreeNode(4);

		System.out.println(findDuplicateSubtrees(tn).size());
	}

	static HashMap<String, Integer> map;
	static List<TreeNode> result;

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		map = new HashMap<String, Integer>();
		result = new ArrayList<TreeNode>();
		serialise(root);
		return result;
	}

	public static String serialise(TreeNode root) {
		if (root == null) {
			return "#";
		}

		String leftString = serialise(root.left);
		String rightString = serialise(root.right);

		String str = root.val + "," + leftString + "," + rightString;
		map.compute(str, (k, v) -> v == null ? 1 : v + 1);
		if (map.get(str) == 2) {
			result.add(root);
		}
		return str;
	}

}
