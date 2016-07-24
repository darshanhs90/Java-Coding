package eBayPrep;

public class _053MaximumSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(maxSubArray(new int[]{-1}));
	}
	public static int maxSubArray(int[] nums) {
		int maxSoFar=nums[0];
		int maxValue=nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxValue=Math.max(nums[i],maxValue+nums[i]);
			maxSoFar=Math.max(maxValue, maxSoFar);
		}
		return maxSoFar;
	}


}

