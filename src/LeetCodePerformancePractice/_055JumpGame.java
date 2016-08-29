package LeetCodePerformancePractice;

public class _055JumpGame {
	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
		System.out.println(canJump(new int[]{3,2,1,0,4}));//false
		System.out.println(canJump(new int[]{2,0}));
		System.out.println(canJump(new int[]{0}));
		System.out.println(canJump(new int[]{0,2}));//false
		System.out.println(canJump(new int[]{2,0,0}));

	}
	public static boolean canJump(int[] nums) {
		if(nums==null||nums.length<=1)
			return true;
		int maxReach=nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(maxReach>=nums.length-1)
				return true;
			if((nums[i]==0 && maxReach<=i)||maxReach<i)
				return false;
			if((i+nums[i])>maxReach)
				maxReach=i+nums[i];
		}
		return maxReach>=nums.length-1;
	}
}

