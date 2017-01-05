package PracticeLeetCode;

public class _053MaximumSubArray {
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));	//->6
	}
	public static int maxSubArray(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int max=nums[0],newSum=nums[0];
		for (int i = 1; i < nums.length; i++) {
			max=Math.max(max+nums[i], nums[i]);
			newSum=Math.max(newSum, max);
		}
		return newSum;
	}
}

