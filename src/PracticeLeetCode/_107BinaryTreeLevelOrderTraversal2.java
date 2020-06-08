package PracticeLeetCode;
import java.util.List;

public class _107BinaryTreeLevelOrderTraversal2 {
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

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(3);
		tn1.left = new TreeNode(9);
		tn1.right = new TreeNode(20);
		tn1.right.left = new TreeNode(15);
		tn1.right.right = new TreeNode(7);
		System.out.println(levelOrderBottom(tn1));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
	}
}
