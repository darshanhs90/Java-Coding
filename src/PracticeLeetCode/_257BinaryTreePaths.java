package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _257BinaryTreePaths {
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
		tn.left.right = new TreeNode(5);
		tn.right = new TreeNode(3);
		List<String> list = binaryTreePaths(tn);
		System.out.println(Arrays.toString(list.toArray()));
		
		tn = new TreeNode(1);
		list = binaryTreePaths(tn);
		System.out.println(Arrays.toString(list.toArray()));
		
		
		tn = new TreeNode(1);
		tn.left = new TreeNode(2);
		list = binaryTreePaths(tn);
		System.out.println(Arrays.toString(list.toArray()));
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return new ArrayList<String>();
		}

		List<String> ls = new ArrayList<String>();
		binaryTreePaths1(root, ls, "");
		return ls;
	}

	public static void binaryTreePaths1(TreeNode root, List<String> ls, String s) {
		if (root == null) {
			return;
		}
		
		if(root.left == null && root.right == null)
		{
			ls.add(s+root.val);
			return;
		}
		
		binaryTreePaths1(root.left, ls, s+root.val + "->");
		binaryTreePaths1(root.right, ls, s+root.val + "->");
	}
}
