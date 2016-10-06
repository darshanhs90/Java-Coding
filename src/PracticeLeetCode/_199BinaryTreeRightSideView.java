package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _199BinaryTreeRightSideView {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		System.out.println(rightSideView(tn));
	}
}