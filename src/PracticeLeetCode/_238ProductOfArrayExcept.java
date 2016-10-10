package PracticeLeetCode;

import java.util.Arrays;

public class _238ProductOfArrayExcept {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
	}
	public static int[] productExceptSelf(int[] nums) {
		int[] temp1=new int[nums.length];
		int[] temp2=new int[nums.length];
		temp1[0]=1;
		temp2[temp2.length-1]=1;
		for (int i = 1; i < temp2.length; i++) {
			temp1[i]=temp1[i-1]*nums[i-1];
		}
		for (int i = temp2.length-2;i>=0; i--) {
			temp2[i]=temp2[i+1]*nums[i+1];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i]=temp1[i]*temp2[i];
		}
		return nums;
	}
}
