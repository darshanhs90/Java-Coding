package PracticeLeetCode;

public class _136SingleNumber {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	public int singleNumber(int[] nums) {
		if(nums==null||nums.length==0)
			return -1;
		int value=nums[0];
		for (int i = 1; i < nums.length; i++) {
			value^=nums[i];
		}
		return value;
	}
}