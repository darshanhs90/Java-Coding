package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _257BinaryTreePaths {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		System.out.println(binaryTreePaths(tn));
	}
	

}
