package leetCode;

/*
 * Link : https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */

public class _129SumRootToLeafNumbers {
	int paths[]=new int[1000];
	public static int sumNumbers(TreeNode root) {
		
		
		
		return 0;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		System.out.println(sumNumbers(tn));
	}
}