package leetCode;

/*
 * Link : https://leetcode.com/problems/house-robber/
 */

public class _198HouseRobber {
	public static int robDP(int[] nums) {
		if(nums.length<1)
			return 0;
		int[] dpOutput=new int[nums.length+1];
		dpOutput[0]=0;
		dpOutput[1]=nums[0];
		for (int i = 2; i < dpOutput.length; i++) {
			dpOutput[i]=Math.max(dpOutput[i-1],dpOutput[i-2]+nums[i-1]);
		}
		return dpOutput[dpOutput.length-1];
	}
	public static int robnonDP(int[] nums) {
		int evenSum=0,oddSum=0;
		for (int i = 0; i < nums.length; i++) {
			if(i%2==0)
			{
				evenSum+=nums[i];
				evenSum=evenSum>oddSum?evenSum:oddSum;
			}
			else{
				oddSum+=nums[i];
				oddSum=evenSum>oddSum?evenSum:oddSum;
			}
		}
		return evenSum>oddSum?evenSum:oddSum;
	}
	public static void main(String[] args) {
		System.out.println(robnonDP(new int[]{50,1,1,50}));
		System.out.println(robDP(new int[]{50,1,1,50}));
	}
}