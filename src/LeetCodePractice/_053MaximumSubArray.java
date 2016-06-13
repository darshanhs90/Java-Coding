package LeetCodePractice;

public class _053MaximumSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

	}
	public static int maxSubArray(int[] nums) {
		int maxSoFar=nums[0];
		int overAllMax=nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxSoFar=Math.max(maxSoFar+nums[i],nums[i]);
			overAllMax= Math.max(overAllMax,maxSoFar);
		}
		return overAllMax;
	}
	
	/* for answer which is positive always
	public static int maxSubArray(int[] nums) {
		int maxSoFar=0;
		int overAllMax=0;
		for (int i = 0; i < nums.length; i++) {
			maxSoFar+=nums[i];
			if(maxSoFar<0)
				maxSoFar=0;
			else{
				overAllMax=Math.max(overAllMax, maxSoFar);
			}
		}
		return overAllMax;
	}*/
}

