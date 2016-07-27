package eBayPrep;

public class _136SingleNumber {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,3,2,4,1,3,4}));

	}
	public static int singleNumber(int[] nums) {
		if(nums.length==1)
			return nums[0];
		int output=nums[0];
		for (int i = 1; i < nums.length; i++) {
			output^=nums[i];
		}
		return output;
	}
}

